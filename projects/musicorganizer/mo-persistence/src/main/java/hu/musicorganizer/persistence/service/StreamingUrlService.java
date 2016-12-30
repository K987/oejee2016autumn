package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface StreamingUrlService {

	StreamingUrl create(String songTitle, String url, String type) throws PersistenceServiceException;
	
	StreamingUrl read(String url) throws PersistenceServiceException;
	
	List<StreamingUrl> readAll(String customerEmailAddress) throws PersistenceServiceException;
	
	boolean exists(String url) throws PersistenceServiceException;
	
}
