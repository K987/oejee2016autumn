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
 *  Shift service facade
 *
 * @author kalmankostenszky
 */
@Local
public interface ShiftServiceLocal {


	/**
	 * reads schedules between two dates
	 * 
	 * @param from
	 * @param to
	 * @return
	 * @throws PersistenceServiceException
	 */
	List<Shift> readCalendarSchedule(Calendar from, Calendar to) throws PersistenceServiceException;

}
