package hu.musicorganizer.webservice;

import hu.musicorganizer.ejbservice.domain.TrackInputStub;
import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class TracklistRestServiceBean implements TracklistRestService {


	private static final Logger LOGGER = Logger.getLogger(TracklistRestServiceBean.class);

	@EJB
	private TracklistFacade facade;
	
	
	@Override
	public List<TracklistStub> getTracklists(String emailAddress)
			throws FacadeException {
		return facade.getTracklists(emailAddress);
	}


	@Override
	public TracklistStub addTrack(TrackInputStub stub)
			throws FacadeException {
		this.facade.addTrack(
				stub.getCustomerEmailAddress(), 
				stub.getTracklistName(), 
				stub.getSongTitle(), 
				stub.getSongCategory(), 
				stub.getStreamingUrl(), 
				stub.getArtistName());
		
		return facade.getTracklist(stub.getCustomerEmailAddress(), stub.getTracklistName());
	}

	
	
}
