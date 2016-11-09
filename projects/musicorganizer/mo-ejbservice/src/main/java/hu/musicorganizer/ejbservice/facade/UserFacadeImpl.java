package hu.musicorganizer.ejbservice.facade;

import javax.ejb.Stateless;

import hu.musicorganizer.ejbservice.domain.UserStub;

@Stateless(mappedName = "ejb/userFacade")
public class UserFacadeImpl implements UserFacade {

	@Override
	public UserStub authenticate(String username, String password) {
		// FIXME remove mocking
		UserStub user = new UserStub();
		user.setUsername(username + "-mock");
		return user;
	}

}
