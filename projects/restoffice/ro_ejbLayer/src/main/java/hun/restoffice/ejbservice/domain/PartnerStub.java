/**
 * 
 */
package hun.restoffice.ejbservice.domain;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.partner.Partner;

/**
 * DTO for partner entity
 *
 * @author kalmankostenszky
 */
public class PartnerStub {

	private static final Logger LOG = Logger.getLogger(PartnerStub.class);

	// fields
	private final String name;
	private final String account;
	private final PartnerContactStub contact;

	// constructor
	/**
	 * Creates a partner entity
	 * 
	 * @param partner
	 * @param account
	 *            required
	 */
	public PartnerStub(final Partner partner, final boolean account) {
		this.name = partner.getName();
		if (account)
			this.account = (partner.getAccount() == null || partner.getAccount() == "") ? "No account number available"
					: partner.getAccount();
		else
			this.account = "XXXXXXXXXXXXXXXXXXXXXXXX";
		if (partner.getContact() != null)
			this.contact = new PartnerContactStub(partner.getContact());
		else
			this.contact = null;
	}

	// getters setters

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("PartnerStub [name=%s, account=%s, contact=%s]", name, account, contact);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @return the contact
	 */
	public PartnerContactStub getContact() {
		return contact;
	}

}
