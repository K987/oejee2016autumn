/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.persistence.entity.employee.Employee;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface EmployeeConverterLocal {

	public List<EmployeeStub> to(List<Employee> readAll);
	
	public EmployeeStub to(Employee create);
	
	public Employee from(EmployeeStub employee);

	/**
	 * @param queryEmpSchedule
	 * @return
	 */
	public EmployeeScheduleStub toSchedule(Employee queryEmpSchedule);
}
