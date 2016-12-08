package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.entity.Tracklist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.TracklistParameter;
import hu.musicorganizer.persistence.query.TracklistQuery;

import java.util.List;

import javax.ejb.EJB;
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
	
	@EJB
	CustomerService customerService;
	
	@EJB
	StreamingUrlService streamingUrlService;
	
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

	@Override
	public Tracklist read(String name, String customerEmailAddress) throws PersistenceServiceException {
		Tracklist result = null;
		try {
			result = this.entityManager.createNamedQuery(TracklistQuery.GET_BY_NAME_AND_CUSTOMER_EMAILADDRESS, Tracklist.class)
					.setParameter(TracklistParameter.CUSTOMER_EMAILADDRESS, customerEmailAddress)
					.setParameter(TracklistParameter.NAME, name)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tracklist by customerEmailAddress (" + customerEmailAddress + ") and name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public void save(Tracklist tracklist) throws PersistenceServiceException {
		try {
			this.entityManager.merge(tracklist);
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error saving trakclist" + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(String name, String customerEmailAddress) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Tracklist by name (" + name + ") and customer e-mail address (" + customerEmailAddress + ")");
		}
		try {
			this.entityManager.createNamedQuery(TracklistQuery.REMOVE_BY_NAME_AND_CUSTOMER_EMAILADDRESS)
			.setParameter(TracklistParameter.NAME, name)
			//.setParameter(TracklistParameter.CUSTOMER_EMAILADDRESS, customerEmailAddress)
			//see comment in tracklist.java at named query
			.executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Tracklist by name (" + name + ") and customer e-mail address (" + customerEmailAddress + ") " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Tracklist create(String customerEmailAddress, String name) throws PersistenceServiceException {

		try {
			
			Customer customer = customerService.read(customerEmailAddress);
			
			final Tracklist tracklist = new Tracklist(customer, name);
			this.entityManager.merge(tracklist);
			return tracklist;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Tracklist (" + name + ")! " + e.getLocalizedMessage(), e);
		} 
	}

	@Override
	public boolean exists(String name, String customerEmailAddress)
			throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(TracklistQuery.COUNT_BY_NAME_AND_CUSTOMER_EMAILADDRESS, Long.class)
					.setParameter(TracklistParameter.CUSTOMER_EMAILADDRESS, customerEmailAddress)
					.setParameter(TracklistParameter.NAME, name)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Tracklist by name (" + name + ") and customer e-mail address (" + customerEmailAddress + ") " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void addExistingTrack(String customerEmailAddress,
			String tracklistName, StreamingUrl streamingUrl) throws PersistenceServiceException {
		try {
			
			Tracklist tracklist = this.read(tracklistName, customerEmailAddress);
			//StreamingUrl streamingUrlObj = streamingUrlService.read(streamingUrl);
			tracklist.getStreamingUrls().add(streamingUrl);
			
			this.entityManager.merge(tracklist);
			this.entityManager.flush();
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Tracklist (" + tracklistName + ")! " + e.getLocalizedMessage(), e);
		} 
	}

}
