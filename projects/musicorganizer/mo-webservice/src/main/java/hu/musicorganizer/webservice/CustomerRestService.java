package hu.musicorganizer.webservice;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/customer")
public interface CustomerRestService {

	@GET
	@Path("/{emailAddress}")
	@Produces("application/json")
	CustomerStub getCustomer(@PathParam("emailAddress") String emailAddress) throws FacadeException;

	
}
