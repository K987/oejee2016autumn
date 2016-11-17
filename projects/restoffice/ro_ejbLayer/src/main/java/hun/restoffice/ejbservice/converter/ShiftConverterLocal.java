/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.persistence.entity.employee.Shift;

/**
 * Convert shift entity and stub back and forth
 *
 * @author kalmankostenszky
 */
@Local
public interface ShiftConverterLocal {

	/**
	 * list of shfts to list of stubs
	 * 
	 * @param readCalendarSchedule
	 * @return
	 */
	List<CalendarScheduleStub> to(List<Shift> readCalendarSchedule);

}
