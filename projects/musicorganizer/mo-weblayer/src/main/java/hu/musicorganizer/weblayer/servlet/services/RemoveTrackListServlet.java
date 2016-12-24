package hu.musicorganizer.weblayer.servlet.services;

import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.RemoveTracklistParameter;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/RemoveTracklist")
public class RemoveTrackListServlet extends HttpServlet {

	private static final long serialVersionUID = 6783299520794268189L;

	private static final Logger LOGGER = Logger.getLogger(RemoveTrackListServlet.class);	
	
	
	@EJB
	TracklistFacade tracklistFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final String tracklistName = req.getParameter(RemoveTracklistParameter.NAME);
		String customerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();			

		try {	
			tracklistFacade.remove(tracklistName, customerEmailAddress);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrlWithErrorMessage(e.getLocalizedMessage()));
			return;
		}
		
		resp.sendRedirect(Page.DASHBOARD.getUrl());
	}
	
}
