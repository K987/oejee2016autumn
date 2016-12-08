package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TracklistFacade {

	TracklistStub createTracklist(String customerEmailAddress, String name) throws FacadeException;
	
	List<TracklistStub> getTracklists(String customerEmailAddress) throws FacadeException;
	
	void addTrack(String customerEmailAddress, String tracklistName, String songTitle, String songCategory, String streamingUrl, String artistName) throws FacadeException;
	
	void removeTrack(String customerEmailAddress, String tracklistName, String streamingUrl) throws FacadeException;

	void remove(String name, String customerEmailAddress) throws FacadeException;
	
	void promoteTracks(List<String> streamingUrls) throws FacadeException;
}
