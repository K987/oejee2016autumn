package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
import hu.musicorganizer.persistence.parameter.TracklistParameter;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.TracklistAttribute;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/Tracklist")
public class TracklistServlet extends HttpServlet {

	private static final long serialVersionUID = -7296869832913226374L;
	
	private static final Logger LOGGER = Logger.getLogger(TracklistServlet.class);	

	@EJB
	TracklistFacade tracklistFacade;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		

		final String tracklistName = req.getParameter(TracklistParameter.NAME);
		final String customerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();
		

		try {
			final TracklistStub tracklist = tracklistFacade.getTracklist(customerEmailAddress, tracklistName);
			req.setAttribute(TracklistAttribute.ATTR_TRACKLIST, tracklist);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage())); 
			return;
		}

		final List<TracklistStub> tracklists = MusicOrganizerSession.getAuthenticatedUser(req).getTracklists();
		req.setAttribute(TracklistAttribute.ATTR_TRACKLISTS, tracklists);

		final RequestDispatcher view = req.getRequestDispatcher(Page.TRACKLIST.getJspName());
		view.forward(req, resp);
	}
}
