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
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.partner.Partner;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/partnerService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartnerService implements PartnerServiceLocal {

	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;

	private static final Logger LOG = Logger.getLogger(PartnerService.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hun.restoffice.persistence.service.PartnerServiceLocal#read(java.lang.
	 * String)
	 */
	@Override
	public Partner read(String partnerName) throws PersistenceServiceException {

		try {
			return this.entityManager.createNamedQuery(Partner.FIND_BY_NAME, Partner.class)
					.setParameter(Partner.NAME, partnerName.toLowerCase().trim()).getSingleResult();
		} catch (NoResultException e) {
			throw new PersistenceServiceException(PersistenceExceptionType.NOT_EXISTS,
					"Partner w/ name " + partnerName + " does not exists", e);
		} catch (NonUniqueResultException e) {
			throw new PersistenceServiceException(PersistenceExceptionType.AMBIGOUS_RESULT,
					"Multiply partner found w/ name " + partnerName + ". You should warn a responsible person", e);
		} catch (Exception e) {
			LOG.error("partner read exception: " + e.getLocalizedMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN,
					"Error during finding partner by name " + partnerName, e);
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.PartnerServiceLocal#readAll()
	 */
	@Override
	public List<Partner> readAll(Boolean technical) throws PersistenceServiceException {
		List<Partner> rtrn = null;
		try{
			if (technical == null){
				//returns all
				rtrn = this.entityManager.createNamedQuery(Partner.FIND_ALL, Partner.class)
						.setParameter(Partner.APPLY_CRITERIA, false)
						.setParameter(Partner.IS_TECHNICAL,false)
						.getResultList();
			} else {
				//return only the tecnical or non technical ones
				rtrn = this.entityManager.createNamedQuery(Partner.FIND_ALL, Partner.class)
						.setParameter(Partner.APPLY_CRITERIA, true)
						.setParameter(Partner.IS_TECHNICAL, technical)
						.getResultList();
			}
			return rtrn;
		} catch (Exception e){
			LOG.error("read all partner exception: "+ e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "Error during retrieving all partners", e);
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.PartnerServiceLocal#deleteUnused()
	 */
	@Override
	public List<Partner> deleteUnused() throws PersistenceServiceException {
		List<Partner> rtrn = null;
		try{
			//get partner with old transactions
			//delete partners from incomes
			//delete partners from expenses
			return rtrn;
		} catch (Exception e) {
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "Error during deleting unused partners", e);
		}
	}
}
