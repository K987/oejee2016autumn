/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.exception.AdaptorException;

/**
 * Employee service facade local interface  
 *
 * @author kalmankostenszky
 */
@Local
public interface EmployeeFacadeLocal {
	
	/**
	 * @return
	 */
	List<EmployeeStub> getAllEmployees() throws AdaptorException;

	/**
	 * @param employee
	 * @return
	 */
	EmployeeStub addEmployee(EmployeeStub employee) throws AdaptorException;

	/**
	 * @param employeeName
	 * @return
	 */
	EmployeeStub removeEmployee(String employeeName) throws AdaptorException;

	/**
	 * @param name
	 * @param f
	 * @param t
	 * @return
	 */
	EmployeeScheduleStub getEmployeeSchedule(String name, Calendar from, Calendar to) throws AdaptorException;

	/**
	 * @param f
	 * @param t
	 * @return
	 */
	CalendarScheduleStub getCalendarSchedule(Calendar f, Calendar t) throws AdaptorException;

}
