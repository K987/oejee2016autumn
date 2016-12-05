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

import hun.restoffice.ejbservice.domain.ExpsnseStub;
import hun.restoffice.ejbservice.facade.ExpenseFacadeLocal;

/**
 *  
 *
 * @author kalmankostenszky
 */
@WebServlet("/ExpenseList")
public class ExpenseListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ExpenseFacadeLocal eFacade;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ExpsnseStub> expenses = this.eFacade.getAllExpenses();
		
		request.setAttribute("expenses", expenses);
		RequestDispatcher dispather = request.getRequestDispatcher("ExpenseList.jsp");
		
		dispather.forward(request, response);
	}
}
