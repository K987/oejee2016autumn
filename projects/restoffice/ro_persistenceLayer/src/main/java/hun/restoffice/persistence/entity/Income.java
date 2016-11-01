package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the incomes database table.
 * 
 */
@Entity
@Table(name="incomes")
@NamedQuery(name="Income.findAll", query="SELECT i FROM Income i")
public class Income implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="income_doc_id", unique=true, nullable=false, length=100)
	private String incomeDocId;

	@Temporal(TemporalType.DATE)
	@Column(name="income_acc_per_end")
	private Date incomeAccPerEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="income_acc_per_start")
	private Date incomeAccPerStart;

	@Column(name="income_description", length=200)
	private String incomeDescription;

	@Column(name="income_doc_type", nullable=false)
	private Integer incomeDocType;

	@Temporal(TemporalType.DATE)
	@Column(name="income_expiry_date")
	private Date incomeExpiryDate;

	@Column(name="income_gross_amount", nullable=false, precision=131089)
	private BigDecimal incomeGrossAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="income_issue_date", nullable=false)
	private Date incomeIssueDate;

	@Column(name="income_last_modified_dt")
	private Timestamp incomeLastModifiedDt;

	@Temporal(TemporalType.DATE)
	@Column(name="income_payed_date")
	private Date incomePayedDate;

	@Column(name="income_payment_method", nullable=false)
	private Integer incomePaymentMethod;

	//bi-directional many-to-one association to IncType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="income_type", nullable=false)
	private IncType incType;

	//bi-directional many-to-one association to Partner
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="income_liable", nullable=false)
	private Partner partner;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="income_last_modified_by")
	private User user;

	public Income() {
	}

	public String getIncomeDocId() {
		return this.incomeDocId;
	}

	public void setIncomeDocId(String incomeDocId) {
		this.incomeDocId = incomeDocId;
	}

	public Date getIncomeAccPerEnd() {
		return this.incomeAccPerEnd;
	}

	public void setIncomeAccPerEnd(Date incomeAccPerEnd) {
		this.incomeAccPerEnd = incomeAccPerEnd;
	}

	public Date getIncomeAccPerStart() {
		return this.incomeAccPerStart;
	}

	public void setIncomeAccPerStart(Date incomeAccPerStart) {
		this.incomeAccPerStart = incomeAccPerStart;
	}

	public String getIncomeDescription() {
		return this.incomeDescription;
	}

	public void setIncomeDescription(String incomeDescription) {
		this.incomeDescription = incomeDescription;
	}

	public Integer getIncomeDocType() {
		return this.incomeDocType;
	}

	public void setIncomeDocType(Integer incomeDocType) {
		this.incomeDocType = incomeDocType;
	}

	public Date getIncomeExpiryDate() {
		return this.incomeExpiryDate;
	}

	public void setIncomeExpiryDate(Date incomeExpiryDate) {
		this.incomeExpiryDate = incomeExpiryDate;
	}

	public BigDecimal getIncomeGrossAmount() {
		return this.incomeGrossAmount;
	}

	public void setIncomeGrossAmount(BigDecimal incomeGrossAmount) {
		this.incomeGrossAmount = incomeGrossAmount;
	}

	public Date getIncomeIssueDate() {
		return this.incomeIssueDate;
	}

	public void setIncomeIssueDate(Date incomeIssueDate) {
		this.incomeIssueDate = incomeIssueDate;
	}

	public Timestamp getIncomeLastModifiedDt() {
		return this.incomeLastModifiedDt;
	}

	public void setIncomeLastModifiedDt(Timestamp incomeLastModifiedDt) {
		this.incomeLastModifiedDt = incomeLastModifiedDt;
	}

	public Date getIncomePayedDate() {
		return this.incomePayedDate;
	}

	public void setIncomePayedDate(Date incomePayedDate) {
		this.incomePayedDate = incomePayedDate;
	}

	public Integer getIncomePaymentMethod() {
		return this.incomePaymentMethod;
	}

	public void setIncomePaymentMethod(Integer incomePaymentMethod) {
		this.incomePaymentMethod = incomePaymentMethod;
	}

	public IncType getIncType() {
		return this.incType;
	}

	public void setIncType(IncType incType) {
		this.incType = incType;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}