/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hun.restoffice.ejbservice.converter.ShiftConverterLocal;
import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.exception.ApplicationError;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.ShiftServiceLocal;

/**
 *  Shift business faacade
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/shiftFacade")
public class ShiftFacade implements ShiftFacadeLocal{

	@EJB
	private ShiftServiceLocal sService;
	
	@EJB
	private ShiftConverterLocal sConverter;
	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.facade.ShiftFacadeLocal#getCalendarSchedule(java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<CalendarScheduleStub> getCalendarSchedule(Calendar from, Calendar to) throws AdaptorException {
		List<CalendarScheduleStub> rtrn = new ArrayList<>();
		try{
			
			rtrn = this.sConverter.to(this.sService.readCalendarSchedule(from,to));
			return rtrn;
		} catch (PersistenceServiceException e){
			throw new AdaptorException(ApplicationError.UNEXPECTED, "excepion occured: getCalendarSchedule params "+from+", "+to);
		}
			
	}

	
}
