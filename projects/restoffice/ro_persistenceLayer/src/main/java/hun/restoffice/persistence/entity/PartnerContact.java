/**
 * 
 */
package hun.restoffice.persistence.entity;

import javax.persistence.*;

/**
 * The embeded class for partner contact information
 *
 */
@Embeddable
public class PartnerContact {
	
	@Column(name="partner_contact_name")
	private String name;
	
	@Column(name="partner_contact_phone")
	private String phone;
	
	@Column(name="partner_contact_email")
	private String email;

	
	public PartnerContact(){
		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
