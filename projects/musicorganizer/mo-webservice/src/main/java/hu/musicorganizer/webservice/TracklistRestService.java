package hu.musicorganizer.webservice;

import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/tracklist")
public interface TracklistRestService {


	@GET
	@Path("/{emailAddress}")
	@Produces("application/json")
	List<TracklistStub> getTracklists(@PathParam("emailAddress") String emailAddress) throws FacadeException;

	
}
