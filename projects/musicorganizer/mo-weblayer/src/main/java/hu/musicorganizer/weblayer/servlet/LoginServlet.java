package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.facade.CustomerFacade;
import hu.musicorganizer.weblayer.servlet.common.Page;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = -8536974135756668553L;
	
	@EJB
	private CustomerFacade customerFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.LOGIN.getJspName());
		view.forward(req, resp);
	}
	
}
