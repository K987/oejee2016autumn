package hu.musicorganizer.persistence.service;

import hu.musicorganizer.persistence.entity.Customer;
import hu.musicorganizer.persistence.exception.PersistenceServiceException;
import hu.musicorganizer.persistence.parameter.CustomerParameter;
import hu.musicorganizer.persistence.query.CustomerQuery;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

@Stateless(mappedName = "ejb/customerService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	
	@PersistenceContext(unitName = "mo-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Customer create(String nickname, String password,
			String emailAddress) throws PersistenceServiceException {

		try {
			
			final Customer customer = new Customer(nickname, password, emailAddress);
			this.entityManager.persist(customer);
			return customer;
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Customer (" + emailAddress + ")! " + e.getLocalizedMessage(), e);
		} 
	}

	@Override
	public boolean exists(String emailAddress)
			throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(CustomerQuery.COUNT_BY_EMAILADDRESS, Long.class)
					.setParameter(CustomerParameter.EMAILADDRESS, emailAddress)
					.getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Customers by emailAddress (" + emailAddress + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Customer read(String emailAddress)
			throws PersistenceServiceException {
		Customer result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_EMAILADDRESS, Customer.class).setParameter(CustomerParameter.EMAILADDRESS, emailAddress).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by emailAddress (" + emailAddress + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Customer update(String oldEmailAddress, String newEmailAddress, String nickname, String password)
			throws PersistenceServiceException {

		try {
			final Customer customer = this.read(oldEmailAddress);
			if (newEmailAddress != null && !newEmailAddress.equals(oldEmailAddress)) {
			
				if (this.exists(newEmailAddress)) {
					throw new PersistenceServiceException("E-mail address " + newEmailAddress + " is already taken by someone else");
				}
				 
				customer.setEmailAddress(newEmailAddress);
			}		
			
			if (password != null && !password.isEmpty()) {
				customer.setPassword(password);
			}

			customer.setNickname(nickname);
			
			return this.entityManager.merge(customer);
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when mergning Customer! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public List<Customer> readAll() throws PersistenceServiceException {
		List<Customer> result = null;
		try {
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_ALL, Customer.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

}
 