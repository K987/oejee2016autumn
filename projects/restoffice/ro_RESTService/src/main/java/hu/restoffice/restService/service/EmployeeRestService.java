/**
 * 
 */
package hu.restoffice.restService.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import hu.restoffice.restService.converter.RESTDate;
import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
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

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<EmployeeStub> getAllEmployees() throws AdaptorException;

	@PUT
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeStub addEmployee(EmployeeStub employee) throws AdaptorException;

	@POST
	@Path("/updateEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeStub updateEmployee(EmployeeStub employee) throws AdaptorException;

	@DELETE
	@Path("/deleteEmployee/{employeeName}")
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeStub removeEmployee(@PathParam("employeeName") String emplyoeeName) throws AdaptorException;

	@GET
	@Path("/getEmployeeSchedule/{employeeName}")
	@Produces(MediaType.APPLICATION_JSON)
	EmployeeScheduleStub getEmployeeSchedule(@PathParam("employeeName") String name, @Context UriInfo ui);
			throws AdaptorException;

	@GET
	@Path("/getCalendarSchedule")
	@Produces(MediaType.APPLICATION_JSON)
	CalendarScheduleStub getCalendarSchedule(@QueryParam("from") RESTDate from, @QueryParam("to") RESTDate to) throws AdaptorException;

}
