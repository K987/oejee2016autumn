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

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.FinanceFacadeLocal;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;
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
	private FinanceFacadeLocal fFacade;

	@EJB
	private PartnerFacadeLocal pFacade;


	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("ExpenseList#doGet() invoked");
		List<ExpenseStub> expenses = getExpenses();
		
		
		request.setAttribute("expenses", expenses);
		request.setAttribute("expensesSize", expenses.size());
		request.setAttribute("partners", getPartners());
		request.setAttribute("costCenters", getCostCenters());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ExpenseList.jsp");

		dispatcher.forward(request, response);
	}
	
	/**
	 * @return
	 */
	private List<CostCenterStub> getCostCenters() {
		LOG.info("ExpenseList#getCostCenters invoked");
		List<CostCenterStub> stubs = new ArrayList<>();
		try{
			stubs = this.fFacade.getAllCostCenters();
		} catch (FacadeException e){
			LOG.error(e);
		}
		return stubs;
	}

	/**
	 * @return
	 */
	private List<PartnerStub> getPartners() {
		LOG.info("ExpenseList#getPartnerNames invoked");
		List<PartnerStub> stubs = new ArrayList<>();
		try {
			stubs = this.pFacade.gatAllPartnerContact();
		} catch (AdaptorException e) {
			LOG.error(e);
		}
		return stubs;
	}

	/**
	 * 
	 * @return
	 */
	private List<ExpenseStub> getExpenses(){
		LOG.info("ExpenseList#getExpenses invoked");
		List<ExpenseStub> stubs = new ArrayList<>();
		try {
			stubs = this.fFacade.getAllExpenses();
			Collections.sort(stubs, new Comparator<ExpenseStub>() {

				@Override
				public int compare(ExpenseStub o1, ExpenseStub o2) {
					int rtrn = o1.getRegistered().getTime().compareTo(o2.getRegistered().getTime());
					return rtrn;
				}
			});

		} catch (FacadeException e) {
			LOG.error(e);
		}
		return stubs;
	}
}
