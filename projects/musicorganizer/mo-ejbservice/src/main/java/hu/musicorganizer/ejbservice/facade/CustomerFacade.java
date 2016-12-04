package hu.musicorganizer.ejbservice.facade;

import javax.ejb.Local;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub authenticate(String emailAddress, String password) throws FacadeException;
	
	CustomerStub register(String nickname, String password,
			String emailAddress) throws FacadeException;
	
	void delete(String emailAddress) throws FacadeException;
}
