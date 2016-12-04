package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TracklistFacade {

	List<TracklistStub> getTracklists(String customerEmailAddress) throws FacadeException;
	
}
