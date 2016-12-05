package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Tracklist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.TracklistParameter;
import hu.musicorganizer.persistence.query.TracklistQuery;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/tracklistService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TracklistServiceImpl implements TracklistService {

	private static final Logger LOGGER = Logger.getLogger(TracklistServiceImpl.class);

	@PersistenceContext(unitName = "mo-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public List<Tracklist> readAll(String customerEmailAddress)
			throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Read all Tracklists");
		}
		List<Tracklist> result = null;
		try {
			result = this.entityManager.createNamedQuery(TracklistQuery.GET_BY_CUSTOMER_EMAILADDRESS, Tracklist.class)
					.setParameter(TracklistParameter.CUSTOMER_EMAILADDRESS, customerEmailAddress)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching all Tracklists! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
