/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.exception.AdaptorException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface ShiftFacadeLocal {

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	List<CalendarScheduleStub> getCalendarSchedule(Calendar from, Calendar to) throws AdaptorException;

	
}
