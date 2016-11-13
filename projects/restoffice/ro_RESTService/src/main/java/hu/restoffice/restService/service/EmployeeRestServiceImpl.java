/**
 * 
 */
package hu.restoffice.restService.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import hu.restoffice.restService.converter.RESTDate;
import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.EmployeeFacadeLocal;

/**
 * An implementation class for EmployeeRestService class
 *
 * @author kalmankostenszky
 */
@Stateless
public class EmployeeRestServiceImpl implements EmployeeRestService {

	private static final Logger LOG = Logger.getLogger(EmployeeRestServiceImpl.class);
	
	@EJB
	private EmployeeFacadeLocal facade;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.service.EmployeeRestService#getAllEmployee()
	 */
	@Override
	public List<EmployeeStub> getAllEmployees() throws AdaptorException {
		LOG.info("get all employees invokded");
		return this.facade.getAllEmployees();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.restoffice.restService.service.EmployeeRestService#addEmployee(hun.restoffice.ejbservice.domain.EmployeeStub)
	 */
	@Override
	public EmployeeStub addEmployee(EmployeeStub employee) throws AdaptorException {
		LOG.info("add employee invoked w/ param: " + employee);
		return this.facade.addEmployee(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.service.EmployeeRestService#updateEmployee(hun.restoffice.ejbservice.domain.
	 * EmployeeStub)
	 */
	@Override
	public EmployeeStub updateEmployee(EmployeeStub employee) throws AdaptorException {
		LOG.info("update employee invoked w/ param: " + employee);
		return this.facade.addEmployee(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.service.EmployeeRestService#removeEmployee(java.lang.String)
	 */
	@Override
	public EmployeeStub removeEmployee(String employeeName) throws AdaptorException {
		LOG.info("remove employee invoked w/ param: " + employeeName);
		return this.facade.removeEmployee(employeeName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.service.EmployeeRestService#getEmployeeSchedule(java.lang.String,
	 * hu.restoffice.restService.converter.RESTDate, hu.restoffice.restService.converter.RESTDate)
	 */
	@Override
	public EmployeeScheduleStub getEmployeeSchedule(String name, UriInfo ui) throws AdaptorException, WebApplicationException {
		
		LOG.info("get employee schedule invoked w/ params: [name : " + name + ", from: " + ui.getQueryParameters().getFirst("from") + ", to: " + ui.getQueryParameters().getFirst("to")  + "]");
		MultivaluedMap<String, String>  = ui.getQueryParameters();
		
		//TODO: ezt befejezni
		Calendar f = from.getDate() != null ? from.getDate() : Calendar.getInstance();

		Calendar t = null;
		if (to.getDate() != null) {
			t = to.getDate();
		} else {
			t = (Calendar) f.clone();
			t.add(Calendar.DAY_OF_YEAR, 14);
		}
		EmployeeScheduleStub rtrn = this.facade.getEmployeeSchedule(name, f, t);
		Collections.sort(rtrn.getWorkdays());
		return rtrn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.service.EmployeeRestService#getCalendarSchedule(java.lang.String,
	 * hu.restoffice.restService.converter.RESTDate, hu.restoffice.restService.converter.RESTDate)
	 */
	@Override
	public CalendarScheduleStub getCalendarSchedule(RESTDate from, RESTDate to) throws AdaptorException {
		LOG.info("get calendar schedule invoked w/ params: [from: "+from.getDate()+", to: "+to.getDate()+"]");
		Calendar f = from.getDate() != null ? from.getDate() : Calendar.getInstance();
		
		Calendar t = null;
		if (to.getDate() != null){
			t = to.getDate();
		} else {
			t = (Calendar)f.clone();
			t.add(Calendar.DAY_OF_YEAR, 14);
		}
		return this.facade.getCalendarSchedule(f,t);
	}
}
