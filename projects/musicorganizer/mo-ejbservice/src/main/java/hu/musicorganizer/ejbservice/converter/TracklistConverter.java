package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.persistence.entity.Tracklist;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TracklistConverter {

	TracklistStub to (Tracklist tracklist);
	
	List<TracklistStub> to (List<Tracklist> tracklists);
}
