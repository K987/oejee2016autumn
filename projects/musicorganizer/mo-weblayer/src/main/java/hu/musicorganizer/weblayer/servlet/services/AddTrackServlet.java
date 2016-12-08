package hu.musicorganizer.weblayer.servlet.services;

import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.SongFacade;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
import hu.musicorganizer.weblayer.servlet.DashboardServlet;
import hu.musicorganizer.weblayer.servlet.common.AddTrackParameter;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.RegistrationParameter;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/AddTrack")
public class AddTrackServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(AddTrackServlet.class);	
	
	private static final long serialVersionUID = -6076751852021517403L;

	@EJB
	TracklistFacade tracklistFacade;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final String artistName = req.getParameter(AddTrackParameter.ARTIST_NAME);
		final String songCategory = req.getParameter(AddTrackParameter.SONG_CATEGORY);
		final String songTitle = req.getParameter(AddTrackParameter.SONG_TITLE);
		final String streamingUrl = req.getParameter(AddTrackParameter.STREAMINGURL);
		final String tracklistName = req.getParameter(AddTrackParameter.TRACKLIST_NAME);

		try {
			String customerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();			
			tracklistFacade.addTrack(customerEmailAddress, tracklistName, songTitle, songCategory, streamingUrl, artistName);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage()));
			return;
		}
		
		resp.sendRedirect(Page.DASHBOARD.getUrl());
	}
	
}
