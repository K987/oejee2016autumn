/**
 * 
 */
package hu.restoffice.restService.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.exception.AdaptorException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Path("/shift")
public interface ShiftRestService {

	/**
	 * 
	 * 
	 * @param uriInfo
	 * @return
	 * @throws AdaptorException
	 */
	@GET
	@Path("/getCalendarSchedule")
	@Produces(MediaType.APPLICATION_JSON)
	List<CalendarScheduleStub> getCalendarSchedule(@Context UriInfo uriInfo) throws AdaptorException;

}
