package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.persistence.entity.StreamingUrl;
import hu.musicorganizer.persistence.entity.Tracklist;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TracklistConverterImpl implements TracklistConverter {

	@EJB
	CustomerConverter customerConverter;
	
	@EJB
	StreamingUrlConverter streamingUrlConverter;
	
	@Override
	public List<TracklistStub> to(List<Tracklist> tracklists) {
		final List<TracklistStub> result = new ArrayList<>();
		for (final Tracklist tracklist : tracklists) {
			result.add(this.to(tracklist));
		}
		return result;
 	}

	@Override
	public TracklistStub to(Tracklist tracklist) {
		final TracklistStub result = new TracklistStub(
				customerConverter.to(tracklist.getCustomer()), 
				tracklist.getName()
				);
		
		for(StreamingUrl streamingUrl : tracklist.getStreamingUrls()) {
			result.getStreamingUrls().add(streamingUrlConverter.to(streamingUrl));
		}
		
		return result;
	}

}
