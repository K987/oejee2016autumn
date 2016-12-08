package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.CustomerFacade;
import hu.musicorganizer.weblayer.servlet.common.LoginParameter;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;
import hu.musicorganizer.weblayer.session.SessionAttribute;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = -8536974135756668553L;
	
	private static final Logger LOGGER = Logger.getLogger(LoginServlet. class);
	
	@EJB
	private CustomerFacade customerFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.LOGIN.getJspName());
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		final String emailAddress = req.getParameter(LoginParameter.EMAIL_ADDRESS);
		final String password = req.getParameter(LoginParameter.PASSWORD);

		CustomerStub authenticatedCustomer = null;
		
		LOGGER.info("Authenticating user " + emailAddress);
		try {
			authenticatedCustomer = customerFacade.authenticate(emailAddress, password);
		} catch (FacadeException e) {
			LOGGER.error(e,e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage())); 
			return;
		}
		
		LOGGER.info("Authentication successful for " + emailAddress);
		

		MusicOrganizerSession.setAuthenticatedUser(req, authenticatedCustomer);
		resp.sendRedirect(Page.DASHBOARD.getUrl());
	}
	
}
