package hun.restoffice.remoteClient.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;

import hun.restoffice.remoteClient.domain.CalendarScheduleStub;

@Remote
public interface ShiftFacadeRemote{

	List<CalendarScheduleStub> getCalendarschedule(Calendar day) throws FacadeException;

}
