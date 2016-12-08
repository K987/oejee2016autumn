package hu.musicorganizer.ejbservice.facade;

import javax.ejb.Local;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;

@Local
public interface CustomerFacade {

	CustomerStub getCustomer(String emailAddress) throws FacadeException;
	
	CustomerStub authenticate(String emailAddress, String password) throws FacadeException;
	
	CustomerStub register(String nickname, String password,
			String emailAddress) throws FacadeException;
	
	CustomerStub update(String oldEmailAddress, String newEmailAddress, String nickname, String password) throws FacadeException;
	
	void delete(String emailAddress) throws FacadeException;
}
