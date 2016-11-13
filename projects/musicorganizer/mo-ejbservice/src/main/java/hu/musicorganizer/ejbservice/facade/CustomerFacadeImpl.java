package hu.musicorganizer.ejbservice.facade;

import javax.ejb.Stateless;

import hu.musicorganizer.ejbservice.domain.CustomerStub;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	@Override
	public CustomerStub authenticate(String username, String password) {
		// FIXME remove mocking
		CustomerStub user = new CustomerStub();
		user.setNickname(username + "-mock");
		return user;
	}

}
