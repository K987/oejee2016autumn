package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Artist;
import hu.musicorganizer.persistence.entity.Song;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import javax.ejb.Local;

@Local
public interface SongService {

	Song create(String title, String category, Artist artist) throws PersistenceServiceException;
	
	Song read(String title) throws PersistenceServiceException;
	
	boolean exists(String title) throws PersistenceServiceException;
	
	
	
}
