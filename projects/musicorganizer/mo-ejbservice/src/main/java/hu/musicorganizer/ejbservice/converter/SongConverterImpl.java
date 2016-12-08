package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.SongStub;
import hu.musicorganizer.persistence.entity.Song;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SongConverterImpl implements SongConverter {

	@EJB
	ArtistConverter artistConverter;
	
	@Override
	public SongStub to(Song song) {
		return new SongStub(
				song.getTitle(), 
				song.getCategory(),
				artistConverter.to(song.getArtist())
			);
	}

}
