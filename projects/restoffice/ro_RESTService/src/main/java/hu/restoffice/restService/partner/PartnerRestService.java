/**
 * 
 */
package hu.restoffice.restService.partner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.exception.AdaptorException;

/**
 *  REST services for partner management
 *  
 * @author kalmankostenszky
 */
@Path("/partner")
public interface PartnerRestService {


	/**
	 * Returns partner contact information in json form
	 * @param partnerName the partners company name
	 * @return json w/ partner contact details
	 * @throws AdaptorException
	 */
	@GET
	@Path("/{partnerName}")
	@Produces("application/json")
	public PartnerContactStub getPartnerContact(@PathParam("partnerName") String partnerName) throws AdaptorException;
	
	
}
