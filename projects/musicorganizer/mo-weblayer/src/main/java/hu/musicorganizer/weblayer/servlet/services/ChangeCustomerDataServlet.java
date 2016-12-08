package hu.musicorganizer.weblayer.servlet.services;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.CustomerFacade;
import hu.musicorganizer.weblayer.servlet.common.ChangeCustomerDataParameter;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/ChangeCustomerData")
public class ChangeCustomerDataServlet extends HttpServlet {

	private static final long serialVersionUID = 2134635166226114847L;

	private static final Logger LOGGER = Logger.getLogger(ChangeCustomerDataServlet.class);	
	
	
	
	@EJB
	CustomerFacade customerFacade;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final String nickname = req.getParameter(ChangeCustomerDataParameter.NICKNAME);
		final String password = req.getParameter(ChangeCustomerDataParameter.PASSWORD);
		final String emailAddress = req.getParameter(ChangeCustomerDataParameter.EMAILADDRESS);
		String originalCustomerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();			

		try {	
			CustomerStub updatedCustomer = customerFacade.update(
					originalCustomerEmailAddress, 
					emailAddress, 
					nickname, 
					password);
			
			MusicOrganizerSession.setAuthenticatedUser(req, updatedCustomer);
			
		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrl(e.getLocalizedMessage()));
			return;
		}
		
		resp.sendRedirect(Page.SETTINGS.getUrl());
	}
}


