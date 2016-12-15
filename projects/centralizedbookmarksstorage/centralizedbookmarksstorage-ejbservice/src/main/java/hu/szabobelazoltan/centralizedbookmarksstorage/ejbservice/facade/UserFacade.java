package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.UserStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;

@Local
public interface UserFacade {
	UserStub getUserByName(String username) throws AdaptorException;
}
