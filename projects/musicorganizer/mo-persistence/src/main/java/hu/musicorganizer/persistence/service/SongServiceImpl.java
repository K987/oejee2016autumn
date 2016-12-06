package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Artist;
import hu.musicorganizer.persistence.entity.Song;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.SongParameter;
import hu.musicorganizer.persistence.query.SongQuery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SongServiceImpl implements SongService {

	
	@PersistenceContext(unitName = "mo-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Song create(String title, String category, Artist artist)
			throws PersistenceServiceException {
		try {
			
			final Song song = new Song(title, category, artist);
			this.entityManager.persist(song);
			return song;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Song (" + title + ", " + category +")! " + e.getLocalizedMessage(), e);
		} 
	}

	@Override
	public boolean exists(String title) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(SongQuery.COUNT_BY_TITLE, Long.class)
					.setParameter(SongParameter.TITLE, title)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Songs by title (" + title + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
