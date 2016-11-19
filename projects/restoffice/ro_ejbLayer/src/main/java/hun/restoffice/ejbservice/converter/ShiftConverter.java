/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.domain.ShiftStub;
import hun.restoffice.persistence.entity.employee.Shift;

/**
 * Convert shift entity and stub back and forth
 *
 * @author kalmankostenszky
 */
@Stateless
public class ShiftConverter implements ShiftConverterLocal {

	
	/**
	 * @param shift
	 * @return
	 */
	private CalendarScheduleStub to(Shift shift) {
		return new CalendarScheduleStub(shift.getStartDate(), shift.getStartTime(), shift.getEmployeeShifts());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.converter.ShiftConverterLocal#to(java.util.List)
	 */
	@Override
	public List<CalendarScheduleStub> toSchedule(List<Shift> shifts) {
		List<CalendarScheduleStub> rtrn = new ArrayList<>();
		for (Shift s : shifts) {
			rtrn.add(to(s));
		}
		return rtrn;
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.ShiftConverterLocal#to(java.util.List)
	 */
	@Override
	public List<ShiftStub> to(List<Shift> shifts) {
		List<ShiftStub> rtrn = new ArrayList<>();
		for (Shift s : shifts) {
			rtrn.add(new ShiftStub(s));
		}
		return rtrn;
	}

}
