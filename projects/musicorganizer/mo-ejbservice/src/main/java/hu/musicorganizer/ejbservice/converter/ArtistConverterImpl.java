package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.ArtistStub;
import hu.musicorganizer.persistence.entity.Artist;

import javax.ejb.Stateless;

@Stateless
public class ArtistConverterImpl implements ArtistConverter {

	@Override
	public ArtistStub to(Artist artist) {
		return new ArtistStub(artist.getName());
	}

}
