package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.StreamingUrlStub;
import hu.musicorganizer.persistence.entity.StreamingUrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class StreamingUrlConverterImpl implements StreamingUrlConverter {

	@EJB
	SongConverter songConverter;
	
	@Override
	public StreamingUrlStub to(StreamingUrl streamingUrl) {
		return new StreamingUrlStub(
				songConverter.to(streamingUrl.getSong()), 
				streamingUrl.getType(), 
				streamingUrl.getUrl()
			);
	}

	@Override
	public List<StreamingUrlStub> to(List<StreamingUrl> streamingUrls) {
		final List<StreamingUrlStub> result = new ArrayList<>();
		for (final StreamingUrl streamingUrl : streamingUrls) {
			result.add(this.to(streamingUrl));
		}
		return result;
	}

}
