package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
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

@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet  {

	private static final long serialVersionUID = 7530410292554324937L;
	
	private static final Logger LOGGER = Logger.getLogger(DashboardServlet.class);	

	@EJB
	TracklistFacade tracklistFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		


		try {
			final List<TracklistStub> tracklists = tracklistFacade.getTracklists(MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress());
			req.setAttribute(TracklistAttribute.ATTR_TRACKLISTS, tracklists);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage())); 
			return;
		}
		
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.DASHBOARD.getJspName());
		view.forward(req, resp);
	}
	
}