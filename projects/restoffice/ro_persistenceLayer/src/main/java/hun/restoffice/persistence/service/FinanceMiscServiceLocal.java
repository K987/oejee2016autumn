/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.financialTransaction.CostCenter;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface FinanceMiscServiceLocal {

	/**
	 * @return
	 */
	List<CostCenter> readAllCostCenter() throws PersistenceServiceException;

}
