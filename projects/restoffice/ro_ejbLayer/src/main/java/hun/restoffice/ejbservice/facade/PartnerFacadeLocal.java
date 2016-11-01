/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.FacadeException;

/**
 * @author kalmankostenszky
 *
 */
@Local
public interface PartnerFacadeLocal {

	List<PartnerStub> getPartnersWithName(CharSequence namePart) throws FacadeException;
	
	List<PartnerStub> getAllPartners() throws FacadeException;
}
