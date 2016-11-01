/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.Partner;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * @author kalmankostenszky
 *
 */
@Local
public interface PartnerServiceLocal {

	/**
	 * Retrive a list of partners whose name contain a charseq
	 * @param namePart
	 * @return List of partners
	 * @throws PersistenceServiceException
	 */
	List<Partner> read(CharSequence namePart) throws PersistenceServiceException;
	
	/**
	 * Retrieve all partners
	 * 
	 * @return list of all partners
	 * @throws PersistenceServiceException
	 */
	List<Partner> readAll() throws PersistenceServiceException;
}
