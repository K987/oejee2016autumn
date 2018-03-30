/**
 *
 */
package hun.restoffice.ejbservice.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import hun.restoffice.persistence.entity.partner.Partner;

/**
 * DTO for partner entity
 *
 * @author kalmankostenszky
 */
public class PartnerStub {

    // private static final Logger LOG = Logger.getLogger(PartnerStub.class);

    private final String name;
    private final String account;
    private final PartnerContactStub contact;
    private final Integer id;

    public PartnerStub(final Partner partner, final boolean account) {
        id = partner.getId();
        name = partner.getName();
        if (account)
            this.account = (partner.getAccount() == null || partner.getAccount() == "") ? "No account number available" : partner.getAccount();
        else
            this.account = "XXXXXXXXXXXXXXXXXXXXXXXX";
        if (partner.getContact() != null)
            contact = new PartnerContactStub(partner.getContact());
        else
            contact = null;
    }

    public PartnerStub(final String name, final String account, final PartnerContactStub contact) {
        super();
        this.name = name;
        this.account = account;
        this.contact = contact;
        id = -1;
    }

    public PartnerStub(final Integer id, final String name, final String account, final PartnerContactStub contact) {
        super();
        this.name = name;
        this.account = account;
        this.contact = contact;
        this.id = id;
    }

    @JsonCreator
    public PartnerStub(@JsonProperty("name") final String name, @JsonProperty("account") final String account, @JsonProperty("contact.name") final String pName,
            @JsonProperty("contact.phone") final String pPhone, @JsonProperty("contact.email") final String pEmail) {
        this(name, account, new PartnerContactStub(pName, pPhone, pEmail));
    }

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

    //	/**
    //	 * @param name
    //	 *            the name to set
    //	 */
    //	public void setName(String name) {
    //		this.name = name;
    //	}

    //	/**
    //	 * @param account
    //	 *            the account to set
    //	 */
    //	public void setAccount(String account) {
    //		this.account = account;
    //	}

    //	/**
    //	 * @param contact
    //	 *            the contact to set
    //	 */
    //	public void setContact(PartnerContactStub contact) {
    //		this.contact = contact;
    //	}

    /**
     * @return the id
     */
    @JsonIgnore
    public Integer getId() {
        return id;
    }

}
