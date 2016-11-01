package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain;

public class UserStub {
	private final String username;
	private final String email;
	private final String password;

	public UserStub(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}
}
