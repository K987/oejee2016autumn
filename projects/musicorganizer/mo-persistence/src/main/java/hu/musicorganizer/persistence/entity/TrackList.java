package hu.musicorganizer.persistence.entity;

import hu.musicorganizer.persistence.parameter.TracklistParameter;
import hu.musicorganizer.persistence.query.TracklistQuery;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tracklist")
@NamedQueries(value = { //
		@NamedQuery(name = TracklistQuery.GET_BY_CUSTOMER_EMAILADDRESS, query = "SELECT tl FROM Tracklist tl WHERE tl.customer.emailAddress=:" + TracklistParameter.CUSTOMER_EMAILADDRESS)
})
public class Tracklist {

	@Id
	@SequenceGenerator(name = "generatorTracklist", sequenceName = "tracklist_tracklist_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTracklist")
	@Column(name = "tracklist_id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tracklist_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;
	
	@Column(name = "tracklist_name", nullable = false)
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "trackliststreamingurl", joinColumns = {
			@JoinColumn(name = "tracklist_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "streamingurl_id",
					nullable = false, updatable = false) })
	private Set<StreamingUrl> streamingUrls;

	public Tracklist() {
		super();
	}
	
	public Tracklist(Customer customer, String name) {
		super();
		this.customer = customer;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer user) {
		this.customer = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<StreamingUrl> getStreamingUrls() {
		return streamingUrls;
	}

	public void setStreamingUrls(Set<StreamingUrl> streamingUrls) {
		this.streamingUrls = streamingUrls;
	}
	
	
}
