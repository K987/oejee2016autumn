/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.exception.FacadeException;

/**
 * @author kalmankostenszky
 *
 */
@Local
public interface PartnerFacadeLocal {

	/**
	 * Returns partner contact information if exists
	 * @param partnerName partner company name
	 * @return partner contact info
	 * @throws AdaptorException 
	 */
	PartnerContactStub getPartnerContact(String partnerName) throws AdaptorException;
}
