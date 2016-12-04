package hu.musicorganizer.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class TracklistStub {
	
	private CustomerStub customer;
	private String name;
	private List<StreamingUrlStub> streamingUrls;

	public TracklistStub(CustomerStub customer, String name) {
		super();
		this.customer = customer;
		this.name = name;
		this.streamingUrls = new ArrayList<StreamingUrlStub>();
	}
	

	public List<StreamingUrlStub> getStreamingUrls() {
		return streamingUrls;
	}

	public void setStreamingUrls(List<StreamingUrlStub> streamingUrls) {
		this.streamingUrls = streamingUrls;
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
