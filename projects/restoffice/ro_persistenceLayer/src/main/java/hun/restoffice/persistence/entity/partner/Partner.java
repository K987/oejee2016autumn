package hun.restoffice.persistence.entity.partner;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import hun.restoffice.persistence.entity.financialTransaction.Expense;
import hun.restoffice.persistence.entity.financialTransaction.FinancialTransaction;
import hun.restoffice.persistence.entity.financialTransaction.Income;

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

	//bi-directional many-to-one association to FinancialTransactions
	@OneToMany(mappedBy="partner", fetch=FetchType.LAZY, targetEntity=FinancialTransaction.class)
	private Set<FinancialTransaction> transactions;
	
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

	public FinancialTransaction addTransaction(Income income) {
		getTransactions().add(income);
		income.setParty(this);

		return income;
	}

	public FinancialTransaction removeTranscation(Income income) {
		getTransactions().remove(income);
		income.setParty(null);

		return income;
	}
	
	public FinancialTransaction addTransaction(Expense expense) {
		getTransactions().add(expense);
		expense.setParty(this);

		return expense;
	}

	public FinancialTransaction removeTransactions(Expense expense) {
		getTransactions().remove(expense);
		expense.setParty(null);

		return expense;
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
	 * @return the transactions
	 */
	public Set<FinancialTransaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(Set<FinancialTransaction> transactions) {
		this.transactions = transactions;
	}

/*
	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}



	public Set<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}
*/

}