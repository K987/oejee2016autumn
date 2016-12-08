package hu.musicorganizer.webservice;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.ejbservice.exception.FacadeException;
import hu.musicorganizer.ejbservice.facade.CustomerFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class CustomerRestServiceBean implements CustomerRestService {

	private static final Logger LOGGER = Logger.getLogger(CustomerRestServiceBean.class);

	@EJB
	private CustomerFacade facade;
	
	@Override
	public CustomerStub getCustomer(String emailAddress)
			throws FacadeException {
		return facade.getCustomer(emailAddress);
	}

	
	
}
