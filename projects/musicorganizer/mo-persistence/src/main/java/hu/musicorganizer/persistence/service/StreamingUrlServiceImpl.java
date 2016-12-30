package hu.musicorganizer.persistence.service;

import java.util.List;

import hu.musicorganizer.persistence.entity.Song;
import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.entity.Tracklist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.CustomerParameter;
import hu.musicorganizer.persistence.parameter.StreamingUrlParameter;
import hu.musicorganizer.persistence.parameter.TracklistParameter;
import hu.musicorganizer.persistence.query.StreamingUrlQuery;
import hu.musicorganizer.persistence.query.TracklistQuery;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StreamingUrlServiceImpl implements StreamingUrlService {

	@PersistenceContext(unitName = "mo-persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	SongService songService;
	
	@Override
	public StreamingUrl create(String songTitle, String url, String type)
			throws PersistenceServiceException {
		try {
			
			Song song = this.songService.read(songTitle);
			
			final StreamingUrl streamingUrl = new StreamingUrl(song, type, url);
			this.entityManager.persist(streamingUrl);
			this.entityManager.flush();
			return streamingUrl;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting StreamingUrl (" + url + ", " + type +")! " + e.getLocalizedMessage(), e);
		} 
	}

	@Override
	public boolean exists(String url) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(StreamingUrlQuery.COUNT_BY_URL, Long.class)
					.setParameter(StreamingUrlParameter.URL, url)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting StreamingUrls by url (" + url + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public StreamingUrl read(String url) throws PersistenceServiceException {
		StreamingUrl result = null;
		try {
			result = this.entityManager.createNamedQuery(StreamingUrlQuery.GET_BY_URL, StreamingUrl.class)
					.setParameter(StreamingUrlParameter.URL, url)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching StreamingUrl by url (" + url + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<StreamingUrl> readAll(String customerEmailAddress)
			throws PersistenceServiceException {
		List<StreamingUrl> result = null;
		try {
			result = this.entityManager.createNamedQuery(StreamingUrlQuery.GET_ALL_BY_CUSTOMER_EMAILADDRESS, StreamingUrl.class)
					.setParameter(CustomerParameter.EMAILADDRESS, customerEmailAddress)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching all StreamingUrls for " + customerEmailAddress +"! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
