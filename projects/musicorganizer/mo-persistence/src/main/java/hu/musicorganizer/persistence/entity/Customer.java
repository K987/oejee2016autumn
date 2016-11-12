package hu.musicorganizer.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
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
}
