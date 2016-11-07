/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.partner.Partner;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * Local persistence services for partner entity
 *
 * @author kalmankostenszky
 */

@Local
public interface PartnerServiceLocal {

	/**
	 * Select partner by name
	 * 
	 * @param partnerName
	 * @return first partner who matches the search criteria
	 * @throws PersistenceServiceException
	 */
	public Partner read(String partnerName) throws PersistenceServiceException;

	/**
	 * Select all partners
	 * @param technical true: to read technical only, false: to read non-technical only, null: to read all
	 * @return
	 * @throws PersistenceServiceException
	 */
	public List<Partner> readAll(Boolean technical) throws PersistenceServiceException;


	/**
	 * Delete all partner enitites w/ no relation to income or expense entitites
	 * @return
	 * @throws PersistenceServiceException
	 */
	public List<Partner> deleteUnused() throws PersistenceServiceException;

}
