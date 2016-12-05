package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.TracklistAttribute;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Tracklist")
public class TracklistServlet extends HttpServlet {

	private static final long serialVersionUID = -7296869832913226374L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


		final List<TracklistStub> tracklists = MusicOrganizerSession.getAuthenticatedUser(req).getTracklists();
		req.setAttribute(TracklistAttribute.ATTR_TRACKLISTS, tracklists);

		final RequestDispatcher view = req.getRequestDispatcher(Page.TRACKLIST.getJspName());
		view.forward(req, resp);
	}
}