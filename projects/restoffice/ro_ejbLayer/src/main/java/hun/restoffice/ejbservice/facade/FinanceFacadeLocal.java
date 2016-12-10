/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.ejbservice.domain.ExpenseTypeStub;
import hun.restoffice.remoteClient.exception.FacadeException;



/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface FinanceFacadeLocal {

	/**
	 * @return
	 */
	List<ExpenseStub> getAllExpenses() throws FacadeException;

	/**
	 * @param docId
	 */
	void deleteExpense(String docId) throws FacadeException;

	/**
	 * @return
	 */
	List<CostCenterStub> getAllCostCenters() throws FacadeException;

	/**
	 * @return
	 */
	List<ExpenseTypeStub> getAllExpenseType() throws FacadeException;

	/**
	 * @param partnerId
	 * @param costCenterId
	 * @param costTypeId
	 * @param paymentMethodOrdinal
	 * @param isPayed
	 * @return
	 */
	List<ExpenseStub> getExpensesMatching(Integer partnerId, Integer costCenterId, Integer costTypeId, Integer paymentMethodOrdinal, Boolean isPayed) throws FacadeException;

	/**
	 * @param docId
	 * @return
	 */
	ExpenseStub getExpenseById(String docId) throws FacadeException;

	/**
	 * @param stub
	 */
	void addExpense(ExpenseStub stub) throws FacadeException;

}
