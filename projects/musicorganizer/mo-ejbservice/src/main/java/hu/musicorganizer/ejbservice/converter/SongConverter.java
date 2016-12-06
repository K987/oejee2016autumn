package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.SongStub;
import hu.musicorganizer.persistence.entity.Song;

import javax.ejb.Local;

@Local
public interface SongConverter {
	
	SongStub to(Song song);
	
}
