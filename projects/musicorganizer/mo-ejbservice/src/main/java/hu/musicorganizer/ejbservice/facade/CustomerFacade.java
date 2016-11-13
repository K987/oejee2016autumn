package hu.musicorganizer.ejbservice.facade;

import javax.ejb.Local;

import hu.musicorganizer.ejbservice.domain.CustomerStub;

@Local
public interface CustomerFacade {

	CustomerStub authenticate(String username, String password);
}
