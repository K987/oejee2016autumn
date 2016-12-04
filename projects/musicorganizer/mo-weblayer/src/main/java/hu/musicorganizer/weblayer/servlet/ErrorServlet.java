package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.weblayer.servlet.common.Page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Error")
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 2211072323602190600L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.ERROR.getJspName());
		view.forward(req, resp);
	}
}
