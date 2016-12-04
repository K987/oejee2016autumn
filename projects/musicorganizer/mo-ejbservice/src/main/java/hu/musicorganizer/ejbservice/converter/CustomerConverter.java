package hu.musicorganizer.ejbservice.converter;

import hu.musicorganizer.ejbservice.domain.CustomerStub;
import hu.musicorganizer.persistence.entity.Customer;

import javax.ejb.Local;

@Local
public interface CustomerConverter {

	CustomerStub to (Customer customer);
}
