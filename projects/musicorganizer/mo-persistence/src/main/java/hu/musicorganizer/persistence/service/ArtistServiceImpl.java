package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Artist;
import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.ArtistParameter;
import hu.musicorganizer.persistence.query.ArtistQuery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

@Stateless
public class ArtistServiceImpl implements ArtistService {
	
	private static final Logger LOGGER = Logger.getLogger(ArtistServiceImpl.class);
	
	@PersistenceContext(unitName = "mo-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Artist create(String name) throws PersistenceServiceException {
		try {
			
			final Artist artist = new Artist(name);
			this.entityManager.persist(artist);
			return artist;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Artist (" + name + ")! " + e.getLocalizedMessage(), e);
		} 
	}

	@Override
	public boolean exists(String name) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(ArtistQuery.COUNT_BY_NAME, Long.class)
					.setParameter(ArtistParameter.NAME, name)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Artists by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
