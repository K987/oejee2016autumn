package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.SettingsAttribute;
import hu.musicorganizer.weblayer.servlet.common.TracklistAttribute;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/Settings")
public class SettingsServlet extends HttpServlet {

	private static final long serialVersionUID = -3857381296490692698L;
	
	private static final Logger LOGGER = Logger.getLogger(SettingsServlet. class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.SETTINGS.getJspName());
		req.setAttribute(SettingsAttribute.ATTR_CUSTOMER, MusicOrganizerSession.getAuthenticatedUser(req));
		view.forward(req, resp);
	}
}
