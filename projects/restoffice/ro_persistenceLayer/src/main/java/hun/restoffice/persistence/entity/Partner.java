package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the partners database table.
 * 
 * revisied
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
	private Integer id;

	@Column(name="parnter_technical", nullable=false)
	private Boolean technical;

	@Column(name="partner_account", length=100)
	private String account;

	@Column(name="partner_name", nullable=false, length=100)
	private String name;

	@Embedded
	private PartnerContact contact;

	/*
	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="partner", fetch=FetchType.LAZY)
	private Set<Expense> expenses;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="partner", fetch=FetchType.LAZY)
	private Set<Income> incomes;
	*/
	

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

	/**
	 * @return the contact
	 */
	public PartnerContact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(PartnerContact contact) {
		this.contact = contact;
	}

/*
	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.set(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.set(null);

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
		income.set(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.set(null);

		return income;
	}
*/

}