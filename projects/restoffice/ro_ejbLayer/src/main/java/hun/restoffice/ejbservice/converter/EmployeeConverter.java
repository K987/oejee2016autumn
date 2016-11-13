/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.persistence.entity.employee.Employee;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless
public class EmployeeConverter implements EmployeeConverterLocal {

	/**
	 * @param readAll
	 * @return
	 */
	@Override
	public List<EmployeeStub> to(List<Employee> readAll) {
		List<EmployeeStub> rtrn = new ArrayList<>();
		for (Employee emp : readAll) {
			rtrn.add(new EmployeeStub(emp));
		}
		return rtrn;
	}

	/**
	 * @param create
	 * @return
	 */
	@Override
	public EmployeeStub to(Employee create) {
		return new EmployeeStub(create);
	}

	/**
	 * @param employee
	 * @return
	 */
	@Override
	public Employee from(EmployeeStub employee) {
		Employee rtrn = new Employee();
		rtrn.setEmployeeName(employee.getName());
		rtrn.setDefaultPosition(employee.getPosition());
		rtrn.setActive(employee.isActive());
		rtrn.setDefaultHourlyWage(employee.getWage());
		return rtrn;
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.EmployeeConverterLocal#toSchedule(hun.restoffice.persistence.entity.employee.Employee)
	 */
	@Override
	public EmployeeScheduleStub toSchedule(Employee queryEmpSchedule) {
		return new EmployeeScheduleStub(queryEmpSchedule.getEmployeeName(), queryEmpSchedule.IsActive(), queryEmpSchedule.getEmployeeShifts());
	}
	
	
}
