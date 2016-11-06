/**
 * 
 */
package hun.restoffice.ejbservice.domain;

import hun.restoffice.persistence.entity.partner.PartnerContact;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class PartnerContactStub {

	// fields
	private final String name;
	private final String phone;
	private final String email;

	// constructors

	/**
	 * @param name
	 * @param phone
	 * @param email
	 */
	public PartnerContactStub(String name, String phone, String email) {
		super();
		this.name = (name == null || name == "") ? "No contact name available" : name;
		this.phone = (phone == null || phone == "") ? "No contact phone available" : phone;
		this.email = (email == null || email == "") ? "No contact email available" : email;
	}

	/**
	 * @param contact
	 */
	public PartnerContactStub(PartnerContact contact) {
		this(contact.getName(), contact.getPhone(), contact.getEmail());
	}

	// public methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("PartnerContactStub [name=%s, phone=%s, email=%s]", name, phone, email);
	}

	// getters setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

}