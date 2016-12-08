package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 2260186741426570819L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		MusicOrganizerSession.setAuthenticatedUser(req, null);
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.LOGIN.getJspName());
		view.forward(req, resp);
		
	}
	
}
