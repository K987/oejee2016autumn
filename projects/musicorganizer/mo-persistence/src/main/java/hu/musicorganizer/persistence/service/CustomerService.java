package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CustomerService {
	
	Customer create(String nickname, String password, 
			String emailAddress) throws PersistenceServiceException;
	
	Customer update(String oldEmailAddress, String newEmailAddress, String nickname, String password) throws PersistenceServiceException;
	
	boolean exists(String emailAddress) throws PersistenceServiceException;
	
	Customer read(String emailAddress) throws PersistenceServiceException;
	
	List<Customer> readAll() throws PersistenceServiceException;
}
