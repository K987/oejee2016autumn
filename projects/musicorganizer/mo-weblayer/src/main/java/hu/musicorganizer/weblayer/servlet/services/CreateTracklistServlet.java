package hu.musicorganizer.weblayer.servlet.services;

import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.RemoveTracklistParameter;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/CreateTracklist")
public class CreateTracklistServlet extends HttpServlet {

	private static final long serialVersionUID = 442100115556661545L;

	private static final Logger LOGGER = Logger.getLogger(CreateTracklistServlet.class);	
	
	
	@EJB
	TracklistFacade tracklistFacade;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//FIXME specify own parameter class? or create a common one?
		final String tracklistName = req.getParameter(RemoveTracklistParameter.NAME);
		String customerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();			

		try {	
			tracklistFacade.createTracklist(customerEmailAddress, tracklistName);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage()));
			return;
		}
		
		//FIXME remove (start of testing promotion)
//
//		try {	
//			List<String> streamingUrls = new ArrayList<String>();
//			streamingUrls.add("https://soundcloud.com/solardisco/altair-nouveau-showdown");
//			streamingUrls.add("https://play.spotify.com/track/3AA8xNhDC0MpqwkGX3EP5V");
//			tracklistFacade.promoteTracks(streamingUrls);
//		} catch (FacadeException e) {
//			LOGGER.error(e, e);
//			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage()));
//			return;
//		}
		//FIXME remove (end of testing promotion)
		
		resp.sendRedirect(Page.DASHBOARD.getUrl());
	}
}
