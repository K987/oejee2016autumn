package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Tracklist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TracklistService {

	List<Tracklist> readAll(String customerEmailAddress) throws PersistenceServiceException;
	
}
