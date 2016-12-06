package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.ejbservice.converter.TracklistConverter;
import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.util.StreamingUrlType;
import hu.musicorganizer.persistence.entity.Artist;
import hu.musicorganizer.persistence.entity.Song;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.service.ArtistService;
import hu.musicorganizer.persistence.service.SongService;
import hu.musicorganizer.persistence.service.StreamingUrlService;
import hu.musicorganizer.persistence.service.TracklistService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/tracklistFacade")
public class TracklistFacadeImpl implements TracklistFacade {

	private static final Logger LOGGER = Logger.getLogger(TracklistFacadeImpl.class); 
	
	@EJB
	SongService songService;
	
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
			} 
			
			Song song = null;
			if (!songService.exists(songTitle)) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("No Song exists by title " + songTitle + ". Creating a new Song entity");
				}
				song = songService.create(songTitle, songCategory, artist);
			} 
			
			if (!streamingUrlService.exists(streamingUrl)) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("No StreamingUrl exists by url " + streamingUrl + ". Creating a new StreamingUrl entity");
				}
				
				//TODO: make enum instead
				String urlType = StreamingUrlType.of(streamingUrl);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Determined type of url is " + urlType);
				}
				
				streamingUrlService.create(song, urlType, streamingUrl);
			}
			
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}



}
