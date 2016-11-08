package hun.restoffice.persistence.entity.partner;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import hun.restoffice.persistence.entity.financialTransaction.Expense;
import hun.restoffice.persistence.entity.financialTransaction.Income;

/**
 * The persistent class for the partners database table.
 * 
 */
@Entity
@Table(name = "partners")
@NamedQueries(value = {
		@NamedQuery(name = Partner.FIND_ALL, query = "SELECT p FROM Partner p WHERE (FALSE=:"
				+ Partner.APPLY_CRITERIA + " or p.technical=:" + Partner.IS_TECHNICAL + ")"),
		@NamedQuery(name = Partner.FIND_BY_NAME, query = "SELECT p FROM Partner p WHERE LOWER(p.name)=:"
				+ Partner.NAME),
		@NamedQuery(name = Partner.COUNT, query = "SELECT COUNT(P) FROM Partner p WHERE LOWER(p.name)=:"
				+ Partner.NAME)
})
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Partner.findAll";
	public static final String FIND_BY_NAME = "Partner.findByName";
	public static final String COUNT = "Partner.count";
	public static final String NAME = "name";
	public static final String IS_TECHNICAL = "technical";
	public static final String APPLY_CRITERIA = "applyCriteria";

	@Id
	@SequenceGenerator(name = "PARTNERS_PARTNERID_GENERATOR", sequenceName = "PARTNERS_PARTNER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTNERS_PARTNERID_GENERATOR")
	@Column(name = "partner_id", updatable = false, unique = true, nullable = false)
	private Integer id;

	@Column(name = "partner_technical", nullable = false)
	private Boolean technical;

	@Column(name = "partner_account", length = 100)
	private String account;

	@Column(name = "partner_name", nullable = false, length = 100)
	private String name;

	@Embedded
	private PartnerContact contact;

	@OneToMany(mappedBy = "party", fetch = FetchType.LAZY, targetEntity = Expense.class)
	private Set<Expense> expenses;

	@OneToMany(mappedBy = "party", fetch = FetchType.LAZY, targetEntity = Income.class)
	private Set<Income> incomes;

	public Partner() {
	}

	/**
	 *
	 * @param name
	 * @param account
	 * @param technical
	 * @param cName
	 * @param cEmail
	 * @param cPhone
	 */
	public Partner(String name, String account, boolean technical, String cName, String cEmail, String cPhone) {
		this.name = name;
		this.account = account;
		this.technical = technical;
		this.contact = new PartnerContact(cName, cEmail, cPhone);
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
	 * @param contact
	 *            the contact to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpense(Expense expense) {
		getExpenses().add(expense);
		expense.setParty(this);

		return expense;
	}

	public Expense removeExpense(Expense expense) {
		getExpenses().remove(expense);
		expense.setParty(null);

		return expense;
	}

	public Set<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}

	public Income addIncome(Income income) {
		getIncomes().add(income);
		income.setParty(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setParty(null);

		return income;
	}

	/**
	 * @param partner
	 */
	public void update(Partner partner) {
		this.setName(partner.getName());
		this.setAccount(partner.getAccount());
		this.setParnterTechnical(partner.getParnterTechnical());
		this.setContact(partner.getContact());
		
	}

}