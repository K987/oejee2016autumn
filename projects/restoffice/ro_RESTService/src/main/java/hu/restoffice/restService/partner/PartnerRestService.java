/**
 * 
 */
package hu.restoffice.restService.partner;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.AdaptorException;

/**
 *  REST services for partner management
 *  
 * @author kalmankostenszky
 */
@Path("/partner")
public interface PartnerRestService {


	/**
	 * Returns partner contact information
	 * @param partnerName the partners company name
	 * @return
	 * @throws AdaptorException
	 */
	@GET
	@Path("/{partnerName}")
	@Produces("application/json")
	PartnerContactStub getPartnerContact(@PathParam("partnerName") String partnerName) throws AdaptorException;
	
	
	/**
	 * Returns partner contact information too all partners 
	 * @return
	 * @throws AdaptorException
	 */
	@GET
	@Path("/allContacts")
	@Produces("application/json")
	List<PartnerStub> getAllPartnerContacts() throws AdaptorException;
	
	
	
}
