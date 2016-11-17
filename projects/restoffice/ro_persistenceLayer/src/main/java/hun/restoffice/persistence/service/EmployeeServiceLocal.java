/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.employee.Employee;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface EmployeeServiceLocal {

	/**
	 * @return
	 */
	List<Employee> readAll() throws PersistenceServiceException;

	/**
	 * 
	 * @param employee
	 * @return
	 * @throws PersistenceServiceException
	 */
	public Employee create(Employee employee) throws PersistenceServiceException;

	/**
	 * @param name
	 * @param from
	 * @param to
	 * @return
	 */
	Employee queryEmpSchedule(String name, Calendar from, Calendar to) throws PersistenceServiceException;

	/**
	 * @param employeeName
	 * @return
	 */
	Employee deleteEmployee(String employeeName) throws PersistenceServiceException;

	/**
	 * @param employee
	 * @return
	 */
	Employee updateEmployee(Employee employee) throws PersistenceServiceException;
	
	

}
