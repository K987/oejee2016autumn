package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.UserStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.User;

@Local
public interface UserConverter {
	UserStub to(User user);
	
	List<UserStub> to(List<User> results);
}
