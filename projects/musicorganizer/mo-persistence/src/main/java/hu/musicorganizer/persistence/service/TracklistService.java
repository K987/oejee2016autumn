package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.entity.Tracklist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TracklistService {

	Tracklist create(String customerEmailAddress, String name) throws PersistenceServiceException;
		
	Tracklist read(String name, String customerEmailAddress) throws PersistenceServiceException;
	
	List<Tracklist> readAll(String customerEmailAddress) throws PersistenceServiceException;
	
	void save(Tracklist tracklist) throws PersistenceServiceException;
	
	void addExistingTrack(String customerEmailAddress, 
			String tracklistName, StreamingUrl streamingUrl) throws PersistenceServiceException;
	
	void delete(String name, String customerEmailAddress) throws PersistenceServiceException;
	
	boolean exists(String name, String customerEmailAddress) throws PersistenceServiceException;
}