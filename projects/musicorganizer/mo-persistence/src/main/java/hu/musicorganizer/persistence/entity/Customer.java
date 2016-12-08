package hu.musicorganizer.persistence.entity;

import hu.musicorganizer.persistence.parameter.CustomerParameter;
import hu.musicorganizer.persistence.query.CustomerQuery;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@NamedQueries(value = { //
		@NamedQuery(name = CustomerQuery.COUNT_BY_EMAILADDRESS, query = "SELECT COUNT(c) FROM Customer c WHERE c.emailAddress=:" + CustomerParameter.EMAILADDRESS),
		@NamedQuery(name = CustomerQuery.GET_BY_EMAILADDRESS, query = "SELECT c FROM Customer c WHERE c.emailAddress=:" + CustomerParameter.EMAILADDRESS),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT c FROM Customer c ORDER BY c.nickname")
})
public class Customer {

	@Id
	@SequenceGenerator(name = "generatorCustomer", sequenceName = "customer_customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCustomer")
	@Column(name = "customer_id", nullable = false)
	private Long id;
	
	@Column(name = "customer_nickname", nullable = false)
	private String nickname;
	
	@Column(name = "customer_password", nullable = false)
	private String password;
	
	@Column(name = "customer_emailAddress", nullable = false)
	private String emailAddress;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Tracklist> trackLists;

	public Customer() {
		super();
	}
	
	public Customer(String nickname, String password, String emailAddress) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String username) {
		this.nickname = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<Tracklist> getTrackLists() {
		return trackLists;
	}

	public void setTrackLists(Set<Tracklist> trackLists) {
		this.trackLists = trackLists;
	}
	
	
}
