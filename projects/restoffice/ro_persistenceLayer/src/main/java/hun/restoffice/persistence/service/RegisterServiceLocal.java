/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.dailyTransaction.Register;
import hun.restoffice.persistence.entity.dailyTransaction.RegisterClose;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Local
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

	/**
	 * @param id
	 * @return
	 */
	Register readRegisterWithId(String id) throws PersistenceServiceException;

	/**
	 * @param id
	 * @param time
	 * @param closeNo
	 * @param amt
	 * @throws PersistenceServiceException 
	 */
	void createRegisterClose(String id, Date time, int closeNo, double amt) throws PersistenceServiceException;

}
