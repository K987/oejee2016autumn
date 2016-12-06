package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Song;
import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.SongParameter;
import hu.musicorganizer.persistence.parameter.StreamingUrlParameter;
import hu.musicorganizer.persistence.query.SongQuery;
import hu.musicorganizer.persistence.query.StreamingUrlQuery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StreamingUrlServiceImpl implements StreamingUrlService {

	@PersistenceContext(unitName = "mo-persistence-unit")
	private EntityManager entityManager;
	
	
	@Override
	public StreamingUrl create(Song song, String url, String type)
			throws PersistenceServiceException {
		try {
			
			final StreamingUrl streamingUrl = new StreamingUrl(song, type, url);
			this.entityManager.persist(streamingUrl);
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

}
