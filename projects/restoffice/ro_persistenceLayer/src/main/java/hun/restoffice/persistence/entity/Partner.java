package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the partners database table.
 * 
 */
@Entity
@Table(name="partners")
@NamedQuery(name="Partner.findAll", query="SELECT p FROM Partner p")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTNERS_PARNTERID_GENERATOR", sequenceName="PARTNERS_PARNTER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNERS_PARNTERID_GENERATOR")
	@Column(name="parnter_id", updatable=false, unique=true, nullable=false)
	private Integer parnterId;

	@Column(name="parnter_technical", nullable=false)
	private Boolean parnterTechnical;

	@Column(name="partner_account", length=100)
	private String partnerAccount;

	@Column(name="partner_contact_email", length=100)
	private String partnerContactEmail;

	@Column(name="partner_contact_name", length=100)
	private String partnerContactName;

	@Column(name="partner_contact_phone", length=100)
	private String partnerContactPhone;

	@Column(name="partner_name", nullable=false, length=100)
	private String partnerName;

	//bi-directional many-to-one association to Expens
	@OneToMany(mappedBy="partner")
	private Set<Expense> expenses;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="partner")
	private Set<Income> incomes;

	public Partner() {
	}

	public Integer getParnterId() {
		return this.parnterId;
	}

	private void setParnterId(Integer parnterId) {
		this.parnterId = parnterId;
	}

	public Boolean getParnterTechnical() {
		return this.parnterTechnical;
	}

	public void setParnterTechnical(Boolean parnterTechnical) {
		this.parnterTechnical = parnterTechnical;
	}

	public String getPartnerAccount() {
		return this.partnerAccount;
	}

	public void setPartnerAccount(String partnerAccount) {
		this.partnerAccount = partnerAccount;
	}

	public String getPartnerContactEmail() {
		return this.partnerContactEmail;
	}

	public void setPartnerContactEmail(String partnerContactEmail) {
		this.partnerContactEmail = partnerContactEmail;
	}

	public String getPartnerContactName() {
		return this.partnerContactName;
	}

	public void setPartnerContactName(String partnerContactName) {
		this.partnerContactName = partnerContactName;
	}

	public String getPartnerContactPhone() {
		return this.partnerContactPhone;
	}

	public void setPartnerContactPhone(String partnerContactPhone) {
		this.partnerContactPhone = partnerContactPhone;
	}

	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setPartner(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setPartner(null);

		return expens;
	}

	public Set<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}

	public Income addIncome(Income income) {
		getIncomes().add(income);
		income.setPartner(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setPartner(null);

		return income;
	}

}