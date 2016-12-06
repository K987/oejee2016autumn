package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.persistence.service.SongService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/songFacade")
public class SongFacadeImpl implements SongFacade {

	private static final Logger LOGGER = Logger.getLogger(SongFacadeImpl.class); 
	
	
	@EJB
	SongService songService;
	


}
