package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.UserStub;

@Local
public interface UserFacade {
	UserStub getUserByName(String username);

	List<UserStub> getAllUsers();
}
