package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Artist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import javax.ejb.Local;

@Local
public interface ArtistService {

	Artist read(String name) throws PersistenceServiceException;
	
	Artist create(String name) throws PersistenceServiceException;
	
	boolean exists(String name) throws PersistenceServiceException;
}
