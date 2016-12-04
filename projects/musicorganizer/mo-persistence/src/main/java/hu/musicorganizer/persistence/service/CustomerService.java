package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import javax.ejb.Local;

@Local
public interface CustomerService {
	
	Customer create(String nickname, String password, 
			String emailAddress) throws PersistenceServiceException;
	
	boolean exists(String emailAddress) throws PersistenceServiceException;
	
	Customer read(String emailAddress) throws PersistenceServiceException;
}
