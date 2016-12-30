package hu.musicorganizer.weblayer.servlet;

import hu.musicorganizer.ejbservice.domain.StreamingUrlStub;
import hu.musicorganizer.ejbservice.domain.TracklistStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.TracklistFacade;
import hu.musicorganizer.weblayer.servlet.common.Page;
import hu.musicorganizer.weblayer.servlet.common.TracklistAttribute;
import hu.musicorganizer.weblayer.session.MusicOrganizerSession;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet  {

	private static final long serialVersionUID = 7530410292554324937L;
	
	private static final Logger LOGGER = Logger.getLogger(DashboardServlet.class);	

	@EJB
	TracklistFacade tracklistFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String customerEmailAddress = MusicOrganizerSession.getAuthenticatedUser(req).getEmailAddress();

		try {
			final List<TracklistStub> customersTracklists = tracklistFacade.getTracklists(customerEmailAddress);
			orderTracklists(customersTracklists);
			req.setAttribute(TracklistAttribute.ATTR_TRACKLISTS, customersTracklists);

		} catch (FacadeException e) {
			LOGGER.error(e, e);
			resp.sendRedirect(Page.ERROR.getUrlWithErrorMessage(e.getLocalizedMessage())); 
			return;
		}
		
		
		final RequestDispatcher view = req.getRequestDispatcher(Page.DASHBOARD.getJspName());
		view.forward(req, resp);
	}
	
	private void orderTracklists(List<TracklistStub> tracklists) {
		//FIXME add "addedDate" field to trackliststreamingurl and order by that...
		
		Collections.sort(tracklists,new Comparator<TracklistStub>(){
			@Override
			public int compare(TracklistStub tl1, TracklistStub tl2) {
				return tl1.getName().compareTo(tl2.getName());
			}});
		
		for (TracklistStub tracklist : tracklists) {
			
			Collections.sort(tracklist.getStreamingUrls(),new Comparator<StreamingUrlStub>(){
				@Override
				public int compare(StreamingUrlStub su1, StreamingUrlStub su2) {
					int artistCompare = su1.getSong().getArtist().getName().compareTo(su2.getSong().getArtist().getName());
					if (artistCompare != 0) {
						return artistCompare;						
					} else {
						return su1.getSong().getTitle().compareTo(su2.getSong().getTitle());
					}
					
				}});
			
		}
	}
	
}