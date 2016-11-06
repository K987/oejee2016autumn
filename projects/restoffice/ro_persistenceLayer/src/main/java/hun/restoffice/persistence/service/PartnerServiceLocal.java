/**
 * 
 */
package hun.restoffice.persistence.service;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.partner.Partner;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  Local persistence services for partner entity
 *
 * @author kalmankostenszky
 */

@Local
public interface PartnerServiceLocal {

	/**
	 * Select partner by name 
	 * @param partnerName
	 * @return first partner who matches the search criteria
	 */
	public Partner read(String partnerName) throws PersistenceServiceException;

	
}
