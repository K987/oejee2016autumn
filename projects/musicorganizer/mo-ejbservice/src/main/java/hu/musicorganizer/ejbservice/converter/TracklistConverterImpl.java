package hu.musicorganizer.ejbservice.converter;

import java.util.List;

import javax.ejb.Stateless;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.persistence.entity.Tracklist;

@Stateless
public class TracklistConverterImpl implements TracklistConverter {

	@Override
	public List<TracklistStub> to(List<Tracklist> tracklists) {
		return null;
	}

}
