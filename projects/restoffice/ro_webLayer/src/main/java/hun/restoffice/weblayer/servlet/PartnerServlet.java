/**
 * 
 */
package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.FacadeException;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;

/**
 * @author kalmankostenszky
 *
 */
@WebServlet("/getPartners")
public class PartnerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String PARAM_NAMEPART = "namePart";
	private static final String ATTRIBUTE_PARTNERS = "partners";
	private static final String PAGE = "partners.jsp";
	

	@EJB
	private PartnerFacadeLocal f;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(PARAM_NAMEPART);
		try{
			List<PartnerStub> lst = this.f.getPartnersWithName(name);
			request.setAttribute(ATTRIBUTE_PARTNERS, lst);
		} catch (FacadeException e) {
			
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}
}
