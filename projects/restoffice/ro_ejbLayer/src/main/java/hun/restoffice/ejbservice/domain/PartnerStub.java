package hun.restoffice.ejbservice.domain;

public class PartnerStub {
	private String name;
	private String contact;
	private String address;
	private String bankAccount;
	private String technical;
	
	public PartnerStub(){
		
	}

	public PartnerStub(String name, String contact, String address, String bankAccount, String technical) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.bankAccount = bankAccount;
		this.technical = technical;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("PartnerStub [name=%s, contact=%s, address=%s, bankAccount=%s, technical=%s]", name,
				contact, address, bankAccount, technical);
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
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the bankAccount
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * @return the technical
	 */
	public String getTechnical() {
		return technical;
	}

	/**
	 * @param technical the technical to set
	 */
	public void setTechnical(String technical) {
		this.technical = technical;
	}
	
	
	
}
