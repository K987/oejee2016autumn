package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.persistence.entity.Customer;

import javax.ejb.Stateless;

@Stateless
public class CustomerConverterImpl implements CustomerConverter {

	@Override
	public CustomerStub to(Customer customer) {
		return new CustomerStub(customer.getNickname(), customer.getEmailAddress());
	}

}
