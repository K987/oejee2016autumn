/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.remoteClient.exception.FacadeException;



/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface ExpenseFacadeLocal {

	/**
	 * @return
	 */
	List<ExpenseStub> getAllExpenses() throws FacadeException;

	/**
	 * @param docId
	 */
	void deleteExpense(String docId) throws FacadeException;

}
