/**
 * 
 */
package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import hun.restoffice.ejbservice.domain.ExpenseTypeStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.domain.PaymentMethodStub;
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

		this.forward(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("ExpenseList#doPost invoked");
		// Map<String, String[]> map = request.getParameterMap();
		// for (Entry<String, String[]> entry : map.entrySet()) {
		// StringBuilder sb = new StringBuilder();
		// for (String value : entry.getValue()) {
		// sb.append(value+", ");
		// }
		// LOG.info(entry.getKey() +" : "+ sb.toString());
		// }
		Integer partnerId = request.getParameter("partner").equals("-1") ? null : Integer.parseInt(request.getParameter("partner"));
		Integer costCenterId = request.getParameter("costCenter").equals("-1") ? null : Integer.parseInt(request.getParameter("costCenter"));
		Integer costTypeId = request.getParameter("costType").equals("-1") ? null : Integer.parseInt(request.getParameter("costType"));
		Integer paymentMethodOrdinal = request.getParameter("paymentMethod").equals("-1") ? null
				: PaymentMethodStub.valueOf(request.getParameter("paymentMethod")).ordinal();
		Boolean isPayed = request.getParameter("isPayed").equals("-1") ? null : request.getParameter("isPayed").equals("1");

		List<ExpenseStub> expenses = getExpenses(partnerId, costCenterId, costTypeId, paymentMethodOrdinal, isPayed);

		request.setAttribute("expenses", expenses);
		request.setAttribute("expensesSize", expenses.size());

		this.forward(request, response);

	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("partners", getPartners());
		request.setAttribute("costCenters", getCostCenters());
		request.setAttribute("costTypes", getExpenseTypes());
		request.setAttribute("today", Calendar.getInstance());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ExpenseList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @return
	 */
	private List<ExpenseTypeStub> getExpenseTypes() {
		LOG.info("ExpenseList#getExpenseTypes invoked");
		List<ExpenseTypeStub> stubs = new ArrayList<>();
		try {
			stubs = this.fFacade.getAllExpenseType();
		} catch (FacadeException e) {
			LOG.error(e);
		}
		return stubs;
	}

	/**
	 * @return
	 */
	private List<CostCenterStub> getCostCenters() {
		LOG.info("ExpenseList#getCostCenters invoked");
		List<CostCenterStub> stubs = new ArrayList<>();
		try {
			stubs = this.fFacade.getAllCostCenters();
		} catch (FacadeException e) {
			LOG.error(e);
		}
		return stubs;
	}

	/**
	 * @return
	 */
	private List<PartnerStub> getPartners() {
		LOG.info("ExpenseList#getPartners invoked");
		List<PartnerStub> stubs = new ArrayList<>();
		try {
			stubs = this.pFacade.gatAllPartner();
		} catch (FacadeException e) {
			LOG.error(e);
		}
		return stubs;
	}

	/**
	 * @param partnerId
	 * @param costCenterId
	 * @param costTypeId
	 * @param paymentMethodOrdinal
	 * @param isPayed
	 * @return
	 */
	private List<ExpenseStub> getExpenses(Integer partnerId, Integer costCenterId, Integer costTypeId, Integer paymentMethodOrdinal, Boolean isPayed) {
		LOG.info("ExpenseList#getExpenses invoked");
		List<ExpenseStub> stubs = new ArrayList<>();
		try {
			stubs = this.fFacade.getExpensesMatching(partnerId, costCenterId, costTypeId, paymentMethodOrdinal,isPayed);
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

	/**
	 * 
	 * @return
	 */
	private List<ExpenseStub> getExpenses() {
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
