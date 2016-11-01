package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.UserStub;

public interface UserFacade {
	UserStub getUserByName(String username);

	List<UserStub> getAllUsers();
}
