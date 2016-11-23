/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import hun.restoffice.persistence.entity.dailyTransaction.RegisterClose;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * 
 *
 * @author kalmankostenszky
 */
public interface RegisterServiceLocal {

	/**
	 * @param day
	 * @return
	 */
	List<RegisterClose> readRegisterClose(Calendar day) throws PersistenceServiceException;

	/**
	 * @return
	 */
	List<RegisterClose> readAllWithLastClose() throws PersistenceServiceException;

}
