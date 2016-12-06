package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.SongStub;
import hu.musicorganizer.persistence.entity.Song;

import javax.ejb.Stateless;

@Stateless
public class SongConverterImpl implements SongConverter {

	@Override
	public SongStub to(Song song) {
		return new SongStub(song.getTitle(), song.getCategory());
	}

}
