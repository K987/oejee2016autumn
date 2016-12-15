package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.UserStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.User;

public class UserConverterImpl implements UserConverter {

	@Override
	public UserStub to(User user) {
		UserStub stub = null;
		if (user != null) {
			stub = new UserStub(user.getName(), user.getEmail(), user.getPassword());
		}
		return stub;
	}

	@Override
	public List<UserStub> to(List<User> results) {
		final List<UserStub> stublist = new ArrayList<>();
		for (User user : results) {
			stublist.add(this.to(user));
		}
		return stublist;
	}

}
