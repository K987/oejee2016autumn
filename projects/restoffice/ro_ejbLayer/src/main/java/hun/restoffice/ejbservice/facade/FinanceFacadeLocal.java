/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.ejbservice.domain.ExpenseStub;
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

}
