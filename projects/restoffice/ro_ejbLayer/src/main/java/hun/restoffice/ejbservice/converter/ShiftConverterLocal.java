/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.persistence.entity.employee.Shift;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface ShiftConverterLocal {

	/**
	 * @param readCalendarSchedule
	 * @return
	 */
	List<CalendarScheduleStub> to(List<Shift> readCalendarSchedule);
	
	



}
