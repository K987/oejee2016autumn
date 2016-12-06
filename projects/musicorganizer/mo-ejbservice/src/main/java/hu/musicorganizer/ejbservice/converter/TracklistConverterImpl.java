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
			TracklistStub tracklistStub = this.to(tracklist);
			for(StreamingUrl streamingUrl : tracklist.getStreamingUrls()) {
				tracklistStub.getStreamingUrls().add(streamingUrlConverter.to(streamingUrl));
			}
			result.add(tracklistStub);
		}
		return result;
 	}

	@Override
	public TracklistStub to(Tracklist tracklist) {
		return new TracklistStub(
				customerConverter.to(tracklist.getCustomer()), 
				tracklist.getName()
				);
	}

}
