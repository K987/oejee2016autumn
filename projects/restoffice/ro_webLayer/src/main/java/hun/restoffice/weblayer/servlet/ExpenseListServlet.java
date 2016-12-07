/**
 * 
 */
package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.ejbservice.facade.ExpenseFacadeLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

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
	
	private static final Logger LOG = Logger.getLogger(ExpenseListServlet.class);
			
	@EJB
	private ExpenseFacadeLocal eFacade;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("ExpenseList#doGet() invoked");
		List<ExpenseStub> expenses = new ArrayList<>();
		try {
			expenses = this.eFacade.getAllExpenses();
			Collections.sort(expenses, new Comparator<ExpenseStub>() {

				@Override
				public int compare(ExpenseStub o1, ExpenseStub o2) {
					int rtrn = o1.getRegistered().getTime().compareTo(o2.getRegistered().getTime());
					return rtrn;
				}
			});
		} catch (FacadeException e) {
			LOG.error(e);
		}
		
		request.setAttribute("expenses", expenses);
		request.setAttribute("expensesSize", expenses.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ExpenseList.jsp");
		
		dispatcher.forward(request, response);
	}
}
