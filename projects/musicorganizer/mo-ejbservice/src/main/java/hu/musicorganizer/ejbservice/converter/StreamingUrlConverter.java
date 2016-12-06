package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.StreamingUrlStub;
import hu.musicorganizer.persistence.entity.StreamingUrl;

import java.util.List;

import javax.ejb.Local;

@Local
public interface StreamingUrlConverter {

	StreamingUrlStub to(StreamingUrl streamingUrl);
	
	List<StreamingUrlStub> to(List<StreamingUrl> streamingUrls);
}
