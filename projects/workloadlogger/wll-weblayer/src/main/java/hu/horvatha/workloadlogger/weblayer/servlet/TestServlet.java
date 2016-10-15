package hu.horvatha.workloadlogger.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.horvatha.workloadlogger.ejbservice.domain.TestStub;
import hu.horvatha.workloadlogger.ejbservice.facade.ITestFacade;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -171875351680498112L;
	
	private static final Logger LOGGER =
			Logger.getLogger(TestServlet.class);

	
	@EJB
	private ITestFacade facade;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse
	response) throws ServletException, IOException {
		
		LOGGER.info("Get count of stubs");

		List<TestStub> books = this.facade.getBooks();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(books.size());
		out.close();
	}
	}
