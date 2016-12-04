package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.CustomerFacade;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.RegistrationParameter;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 7433982666633762950L;

	
	private static final Logger LOGGER = Logger.getLogger(RegistrationServlet. class);
	
	@EJB
	private CustomerFacade customerFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		

		final RequestDispatcher view = req.getRequestDispatcher(Page.REGISTRATION.getJspName());
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		final String emailAddress = req.getParameter(RegistrationParameter.EMAIL_ADDRESS);
		final String nickname = req.getParameter(RegistrationParameter.NICKNAME);
		final String password = req.getParameter(RegistrationParameter.PASSWORD);


		try {
			customerFacade.register(nickname, password, emailAddress);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage()));
			return;
		}
		
		resp.sendRedirect(Page.DASHBOARD.getUrl());

	}
}
