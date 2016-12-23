package hu.musicorganizer.weblayer.servlet.services;

import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.RemoveTrackParameter;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/RemoveTrack")
public class RemoveTrackServlet extends HttpServlet {

	private static final long serialVersionUID = 396858151405154647L;

	private static final Logger LOGGER = Logger.getLogger(RemoveTrackServlet.class);	
	
	
	@EJB
	TracklistFacade tracklistFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final String streamingUrl = req.getParameter(RemoveTrackParameter.STREAMINGURL);
		final String tracklistName = req.getParameter(RemoveTrackParameter.TRACKLIST_NAME);
		
		try {
			String customerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();			
			tracklistFacade.removeTrack(customerEmailAddress, tracklistName, streamingUrl);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage()));
			return;
		}
		
		resp.sendRedirect(Page.TRACKLIST.getUrl());
	}
}
