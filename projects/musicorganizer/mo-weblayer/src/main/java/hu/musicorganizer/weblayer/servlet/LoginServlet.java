package hu.musicorganizer.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.musicorganizer.ejbservice.domain.UserStub;
import hu.musicorganizer.ejbservice.facade.UserFacade;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	@EJB
	private UserFacade userFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		UserStub user = userFacade.authenticate("levair", "Levair123");
		
		out.println("Welcome to Music Organizer! \n Logged in as " + user.getUsername());
		out.close();
	}
	
}
