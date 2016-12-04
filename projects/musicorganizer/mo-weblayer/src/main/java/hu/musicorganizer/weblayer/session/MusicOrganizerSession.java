package hu.musicorganizer.weblayer.session;

import hu.musicorganizer.ejbservice.domain.CustomerStub;

import javax.servlet.http.HttpServletRequest;

public class MusicOrganizerSession {
	
	public static CustomerStub getAuthenticatedUser(HttpServletRequest request) {
		return (CustomerStub)request.getSession().getAttribute(SessionAttribute.AUTHENTICATED_USER);
	}
	
}
