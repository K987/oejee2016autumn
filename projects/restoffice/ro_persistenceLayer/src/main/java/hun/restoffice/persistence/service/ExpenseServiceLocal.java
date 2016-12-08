/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.financialTransaction.Expense;
import hun.restoffice.persistence.entity.financialTransaction.PaymentMethod;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface ExpenseServiceLocal {

	/**
	 * @return
	 */
	List<Expense> readAll() throws PersistenceServiceException;

	/**
	 * @param docId
	 */
	void deleteExpense(String docId) throws PersistenceServiceException;

	/**
	 * @param partnerId
	 * @param costCenterId
	 * @param costTypeId
	 * @param pm
	 * @param isPayed
	 * @return
	 */
	List<Expense> readFiltered(Integer partnerId, Integer costCenterId, Integer costTypeId, PaymentMethod pm, Boolean isPayed) throws PersistenceServiceException;

}
