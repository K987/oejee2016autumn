package hun.restoffice.remoteClient.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 * 
 * Remote interface for ShiftFacade EJB 
 *
 * @author kalmankostenszky
 */
@Remote
public interface ShiftFacadeRemote{

	/**
	 * Retruns the work schedule of a given day
	 * @param day
	 * @return
	 * @throws FacadeException
	 */
	List<CalendarScheduleStub> getCalendarschedule(Calendar day) throws FacadeException;

}
