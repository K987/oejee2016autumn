package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.ArtistStub;
import hu.musicorganizer.persistence.entity.Artist;

import javax.ejb.Local;

@Local		
public interface ArtistConverter {

	ArtistStub to(Artist artist);
	
}
