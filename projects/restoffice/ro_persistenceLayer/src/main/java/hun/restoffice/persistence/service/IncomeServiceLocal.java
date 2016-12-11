/**
 * 
 */
package hun.restoffice.persistence.service;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.financialTransaction.Income;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface IncomeServiceLocal {

	/**
	 * @param income
	 */
	void insert(Income income) throws PersistenceServiceException;

}
