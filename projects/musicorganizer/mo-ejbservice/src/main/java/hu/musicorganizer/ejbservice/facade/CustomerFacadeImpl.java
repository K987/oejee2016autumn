package hu.musicorganizer.ejbservice.facade;

import hu.musicorganizer.ejbservice.converter.CustomerConverter;
import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.service.CustomerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class); 
	
	@EJB
	private CustomerService service;
	
	@EJB
	private CustomerConverter converter;
	
	@Override
	public CustomerStub authenticate(String emailAddress, String password) throws FacadeException {
		try {

			if (!service.exists(emailAddress)) {
				throw new FacadeException("No customer exists by email address " + emailAddress);
			} else {				
				Customer customer = this.service.read(emailAddress);
				
				if (!customer.getPassword().equals(password)) {
					throw new FacadeException("Password doesn't match for " + emailAddress);
				}
				
				return this.converter.to(customer);
			}
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public CustomerStub register(String nickname, String password,
			String emailAddress) throws FacadeException {
		
		try {

			if (service.exists(emailAddress)) {
				throw new FacadeException("Customer already exists by email address " + emailAddress);
			} else {				
				Customer customer = this.service.create(nickname, password, emailAddress);
				return this.converter.to(customer);
			}
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void delete(String emailAddress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerStub update(String oldEmailAddress, String newEmailAddress,
			String nickname, String password) throws FacadeException {
		
		try {

			return converter.to(this.service.update(oldEmailAddress, newEmailAddress, nickname, password));
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		
	}

	@Override
	public CustomerStub getCustomer(String emailAddress) throws FacadeException {
		try {

			if (!service.exists(emailAddress)) {
				throw new FacadeException("No customer exists by email address " + emailAddress);
			} else {				
				return this.converter.to(this.service.read(emailAddress));
			}
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
