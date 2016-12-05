package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.ejbservice.converter.TracklistConverter;
import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.service.TracklistService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/tracklistFacade")
public class TracklistFacadeImpl implements TracklistFacade {

	private static final Logger LOGGER = Logger.getLogger(TracklistFacadeImpl.class); 
	
	@EJB
	TracklistConverter converter;
	
	@EJB
	TracklistService service;
	
	@Override
	public List<TracklistStub> getTracklists(String customerEmailAddress) throws FacadeException {
		try {
			return this.converter.to(this.service.readAll(customerEmailAddress));
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException("Failed to get all Tracklists");
		}
	}

}
