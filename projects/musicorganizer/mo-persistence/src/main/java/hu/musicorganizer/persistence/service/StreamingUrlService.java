package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Song;
import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import javax.ejb.Local;

@Local
public interface StreamingUrlService {

	StreamingUrl create(Song song, String url, String type) throws PersistenceServiceException;
	
	boolean exists(String url) throws PersistenceServiceException;
	
}
