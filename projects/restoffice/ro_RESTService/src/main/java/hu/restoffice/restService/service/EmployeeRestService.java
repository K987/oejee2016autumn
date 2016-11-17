/**
 * 
 */
package hu.restoffice.restService.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import hu.restoffice.restService.param.DateParam;
import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.exception.AdaptorException;

/**
 * REST service for employees
 *
 * @author kalmankostenszky
 */
@Path("/employee")
public interface EmployeeRestService {

	/**
	 * getl all employees as JSON
	 * @return
	 * @throws AdaptorException
	 */
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<EmployeeStub> getAllEmployees() throws AdaptorException;

	/**
	 * add new employee
	 * @param employee
	 * @return
	 * @throws AdaptorException
	 */
	@PUT
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeStub addEmployee(EmployeeStub employee) throws AdaptorException;

	/**
	 * update employee data
	 * @param employee
	 * @return
	 * @throws AdaptorException
	 */
	@POST
	@Path("/updateEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeStub updateEmployee(EmployeeStub employee) throws AdaptorException;

	/**
	 * obsolete employee
	 * 
	 * @param emplyoeeName
	 * @return
	 * @throws AdaptorException
	 */
	@DELETE
	@Path("/deleteEmployee/{employeeName}")
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeStub removeEmployee(@PathParam("employeeName") String emplyoeeName) throws AdaptorException;

	/**
	 * get employee schedule between to dates
	 * 	in case of missing data params from: today - to: today + 14 days
	 * @param name
	 * @param from
	 * @param to
	 * @return
	 * @throws AdaptorException
	 * @throws WebApplicationException
	 */
	@GET
	@Path("/getEmployeeSchedule/{employeeName}")
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeScheduleStub getEmployeeSchedule(@PathParam("employeeName") String name,@QueryParam("from") DateParam from, @QueryParam("to") DateParam to)
			throws AdaptorException, WebApplicationException;
}
