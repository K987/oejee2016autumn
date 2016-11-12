package hu.musicorganizer.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@SequenceGenerator(name = "generatorUser", sequenceName = "user_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorUser")
	@Column(name = "user_id", nullable = false)
	private Long id;
	
	@Column(name = "user_username", nullable = false)
	private String username;
	
	@Column(name = "user_password", nullable = false)
	private String password;
	
	@Column(name = "user_emailAddress", nullable = false)
	private String emailAddress;

	public User(String username, String password, String emailAddress) {
		super();
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
