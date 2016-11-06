package hun.restoffice.persistence.entity.partner;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

import hun.restoffice.persistence.entity.financialTransaction.Expense;
import hun.restoffice.persistence.entity.financialTransaction.FinancialTransaction;
import hun.restoffice.persistence.entity.financialTransaction.Income;

/**
 * The persistent class for the partners database table.
 * 
 */
@Entity
@Table(name="partners")
@NamedQueries(value = { 
		@NamedQuery(name=Partner.FIND_ALL, query="SELECT p FROM Partner p"
				+" WHERE (FALSE=:"+Partner.APPLY_CRITERIA+" or p.technical=:"+ Partner.IS_TECHNICAL+")"),
		@NamedQuery(name=Partner.FIND_BY_NAME, query="SELECT p FROM Partner p"
				+ " WHERE LOWER(p.name)=:"+ Partner.NAME)
})
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Partner.findAll";
	public static final String FIND_BY_NAME = "Partner.findByName";
	public static final String NAME = "name";
	public static final String IS_TECHNICAL = "technical";
	public static final String APPLY_CRITERIA = "applyCriteria";

	@Id
	@SequenceGenerator(name="PARTNERS_PARNTERID_GENERATOR", sequenceName="PARTNERS_PARNTER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNERS_PARNTERID_GENERATOR")
	@Column(name="partner_id", updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(name="parnter_technical", nullable=false)
	private Boolean technical;

	@Column(name="partner_account", length=100)
	private String account;

	@Column(name="partner_name", nullable=false, length=100)
	private String name;

	@Embedded
	private PartnerContact contact;

	

	public Partner() {
	}

	public Integer getId() {
		return this.id;
	}


	public Boolean getParnterTechnical() {
		return this.technical;
	}

	public void setParnterTechnical(Boolean parnterTechnical) {
		this.technical = parnterTechnical;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String partnerAccount) {
		this.account = partnerAccount;
	}
	
	public PartnerContact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(PartnerContact contact) {
		this.contact = contact;
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

}