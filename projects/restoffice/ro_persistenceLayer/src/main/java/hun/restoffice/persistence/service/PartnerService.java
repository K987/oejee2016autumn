/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.Partner;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * @author kalmankostenszky
 *
 */
@Stateless(mappedName = "ejb/partnerService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartnerService implements PartnerServiceLocal {

	private static final Logger LOGGER = Logger.getLogger(PartnerService.class);
	
	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager em;
	
	@Override
	public List<Partner> read(CharSequence namePart) throws PersistenceServiceException {
		LOGGER.info("get partners by name: " + namePart);
		
		List<Partner> rtrn = null;
		String name = "%"+namePart+"%";
		try {
			rtrn = this.em.createNamedQuery(Partner.GET_ALL_WITH_NAME, Partner.class).setParameter(Partner.NAME, name).getResultList();
		} catch (final Exception e) {
			LOGGER.error(e.getStackTrace());
			throw new PersistenceServiceException("Error happend while fetching partners with name "+namePart+". Message: "+ e.getLocalizedMessage(),e);
		}
		return rtrn;
	}

	@Override
	public List<Partner> readAll() throws PersistenceServiceException {
		LOGGER.info("getting all partners");
		
		List<Partner> rtrn = null;
		try {
			rtrn = this.em.createNamedQuery(Partner.GET_ALL, Partner.class).getResultList();
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
			throw new PersistenceServiceException("Error happend while fetching partners all partners. Message: "+ e.getLocalizedMessage(),e);
		}
		
		return rtrn;
	}

}
