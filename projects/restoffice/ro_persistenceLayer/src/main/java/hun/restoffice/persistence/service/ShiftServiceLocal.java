/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.employee.Shift;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface ShiftServiceLocal {

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	List<Shift> readCalendarSchedule(Calendar from, Calendar to) throws PersistenceServiceException;

}
