/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.EmployeeConverterLocal;
import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.exception.ApplicationError;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.EmployeeServiceLocal;

/**
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/employeeFacade")
public class EmployeeFacade implements EmployeeFacadeLocal {

	private static Logger LOG = Logger.getLogger(EmployeeFacade.class);

	@EJB
	private EmployeeServiceLocal eService;

	@EJB
	private EmployeeConverterLocal eConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#getAllEmployees()
	 */
	@Override
	public List<EmployeeStub> getAllEmployees() throws AdaptorException {
		if (LOG.isDebugEnabled())
			LOG.debug("getAllEmployess invoked");
		try {
			final List<EmployeeStub> rtrn = this.eConverter.to(this.eService.readAll());
			return rtrn;
		} catch (PersistenceServiceException e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#addEmployee(hun.restoffice.ejbservice.domain.EmployeeStub)
	 */
	@Override
	public EmployeeStub addEmployee(EmployeeStub employee) throws AdaptorException {
		if (LOG.isDebugEnabled())
			LOG.debug("addEmpolyee invoked w/ param: [employee: " + employee + "]");
		try {
			return this.eConverter.to(this.eService.create(this.eConverter.from(employee)));
		} catch (PersistenceServiceException e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#removeEmployee(java.lang.String)
	 */
	@Override
	public EmployeeStub removeEmployee(String employeeName) throws AdaptorException {
		if (LOG.isDebugEnabled())
			LOG.debug("removeEmployee invoked w/ param " + employeeName);

		// TODO: na most itt ki kell találni, hogy tényleg employee-t adjak vissza
		throw new AdaptorException(ApplicationError.UNEXPECTED, "not implemented");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#getEmployeeSchedule(java.lang.String,
	 * java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public EmployeeScheduleStub getEmployeeSchedule(String name, Calendar from, Calendar to) throws AdaptorException {
		if (LOG.isDebugEnabled())
			LOG.debug("getEmployeeSchedule invoked w/ param: [employee name: " + name + ", from: " + from + ", to: " + to + "]");
		try{
		return this.eConverter.toSchedule(this.eService.queryEmpSchedule(name, from, to));
		} catch (PersistenceServiceException e) {
			
			throw new AdaptorException(ApplicationError.UNEXPECTED, "not implemented");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#getCalendarSchedule(java.util.Calendar,
	 * java.util.Calendar)
	 */
	@Override
	public CalendarScheduleStub getCalendarSchedule(Calendar from, Calendar to) throws AdaptorException {
		if (LOG.isDebugEnabled())
			LOG.debug("getEmployeeSchedule invoked w/ param: [from: " + from + ", to: " + to + "]");

		// TODO: na most itt ki kell találni, hogy mit is akarjak visszadni
		throw new AdaptorException(ApplicationError.UNEXPECTED, "not implemented");
	}

}
