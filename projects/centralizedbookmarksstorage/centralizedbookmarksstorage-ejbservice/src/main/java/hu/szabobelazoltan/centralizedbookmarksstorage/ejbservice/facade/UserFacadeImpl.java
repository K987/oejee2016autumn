package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter.UserConverter;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.UserStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Share;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.User;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.UserService;

@Stateless
public class UserFacadeImpl implements UserFacade {

	@EJB
	private UserService userService;
	
	@EJB
	private UserConverter converter;
	
	@Override
	public UserStub getUserByName(String username) throws AdaptorException {
		UserStub stub = null;
		try {
			User results = this.userService.read(username);
			stub = this.converter.to(results);
		} catch (final Exception e) {
			throw new AdaptorException("Unknown error!", e);
		}
		return stub;
	}

}
