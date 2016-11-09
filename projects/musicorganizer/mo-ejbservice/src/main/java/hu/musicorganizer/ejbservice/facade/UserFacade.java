package hu.musicorganizer.ejbservice.facade;

import javax.ejb.Local;

import hu.musicorganizer.ejbservice.domain.UserStub;

@Local
public interface UserFacade {

	UserStub authenticate(String username, String password);
}
