package hu.musicorganizer.ejbservice.domain;

public class TrackListStub {
	
	private CustomerStub customer;
	private String name;

	public TrackListStub(CustomerStub customer, String name) {
		super();
		this.customer = customer;
		this.name = name;
	}

	public CustomerStub getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerStub user) {
		this.customer = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
