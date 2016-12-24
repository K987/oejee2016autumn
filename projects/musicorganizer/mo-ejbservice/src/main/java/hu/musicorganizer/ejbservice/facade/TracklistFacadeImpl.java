package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.ejbservice.converter.TracklistConverter;
import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.util.StreamingUrlType;
import hu.musicorganizer.persistence.entity.Artist;
import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.entity.Tracklist;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.service.ArtistService;
import hu.musicorganizer.persistence.service.CustomerService;
import hu.musicorganizer.persistence.service.SongService;
import hu.musicorganizer.persistence.service.StreamingUrlService;
import hu.musicorganizer.persistence.service.TracklistService;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/tracklistFacade")
public class TracklistFacadeImpl implements TracklistFacade {

	private static final Logger LOGGER = Logger.getLogger(TracklistFacadeImpl.class); 
	
	public static final String PROMOTIONAL_TRACKLIST_NAME = "Popular now!";
	
	@EJB
	SongService songService;
	
	@EJB
	CustomerService customerService;
	
	@EJB
	ArtistService artistService;
	
	@EJB
	TracklistService tracklistService;

	@EJB
	StreamingUrlService streamingUrlService;
	
	@EJB
	TracklistConverter converter;
	
	@Override
	public List<TracklistStub> getTracklists(String customerEmailAddress) throws FacadeException {
		try {
			return this.converter.to(this.tracklistService.readAll(customerEmailAddress));
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException("Failed to get all Tracklists");
		}
	}

	@Override
	public void addTrack(String customerEmailAddress, String tracklistName,
			String songTitle, String songCategory, String streamingUrl,
			String artistName) throws FacadeException {
		try {
			Artist artist = null;
			if (!artistService.exists(artistName)) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("No Artist exists by name " + artistName + ". Creating a new Artist entity");
				}
				artist = artistService.create(artistName);
			} else {
				artist = artistService.read(artistName);
			}
			
			if (!songService.exists(songTitle)) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("No Song exists by title " + songTitle + ". Creating a new Song entity");
				}
				songService.create(songTitle, songCategory, artist);
			} 
			
			StreamingUrl streamingUrlObj = null;
			if (!streamingUrlService.exists(streamingUrl)) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("No StreamingUrl exists by url " + streamingUrl + ". Creating a new StreamingUrl entity");
				}
				
				//TODO: make enum instead
				String urlType = StreamingUrlType.of(streamingUrl);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Determined type of url is " + urlType);
				}
				
				streamingUrlObj = streamingUrlService.create(songTitle, streamingUrl, urlType);
			} else {
				streamingUrlObj = streamingUrlService.read(streamingUrl);
			}
			
			tracklistService.addExistingTrack(customerEmailAddress, tracklistName, streamingUrlObj);
			
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void removeTrack(String customerEmailAddress, String tracklistName,
			String streamingUrl) throws FacadeException {
		try {

			Tracklist tracklist = tracklistService.read(tracklistName, customerEmailAddress);
			Iterator<StreamingUrl> it = tracklist.getStreamingUrls().iterator();
			while (it.hasNext())
			{
			    StreamingUrl streamingUrlObj = it.next();
			    if (streamingUrlObj.getUrl().equals(streamingUrl)) {
			    	it.remove();
			    	break;
			    }
			}
			
			tracklistService.save(tracklist);
			
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void remove(String name, String customerEmailAddress)
			throws FacadeException {
		try {
			tracklistService.delete(name, customerEmailAddress);
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public TracklistStub createTracklist(String customerEmailAddress,
			String name) throws FacadeException {
		try {
			return converter.to(tracklistService.create(customerEmailAddress, name));
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void promoteTracks(List<String> streamingUrls)
			throws FacadeException {
		
		try {
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Promoting " + streamingUrls.size() + " tracks for all Customers");
			}
			List<Customer> customers = customerService.readAll();
			for (Customer customer : customers) {
				
				String emailAddress = customer.getEmailAddress();

				if (!tracklistService.exists(PROMOTIONAL_TRACKLIST_NAME, emailAddress)) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Customer " + emailAddress + " has no promotional Tracklist yet, creating one");
					}
					tracklistService.create(emailAddress, PROMOTIONAL_TRACKLIST_NAME);
				} 
				
				for (String promotedStreamingUrl : streamingUrls) {
					if (streamingUrlService.exists(promotedStreamingUrl)) {
						
						//FIXME pass string instead
						StreamingUrl streamingUrlObj = streamingUrlService.read(promotedStreamingUrl);
						
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug("Adding streamingUrl " + promotedStreamingUrl + " to promotional tracklist of " + emailAddress);
						}						
						tracklistService.addExistingTrack(emailAddress, PROMOTIONAL_TRACKLIST_NAME, streamingUrlObj);
					} else if (LOGGER.isDebugEnabled()) {
						 LOGGER.debug("StreamingUrl " + promotedStreamingUrl + " is not known to Music Organizer, skipping");
					}
				}	
			}
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		
	}

	@Override
	public TracklistStub getTracklist(String customerEmailAddress, String name)
			throws FacadeException {
		try {
			return this.converter.to(this.tracklistService.read(name, customerEmailAddress));
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException("Failed to get Tracklist by name " + name + " for customer " + customerEmailAddress);
		}
	}



}
