package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the expenses database table.
 * 
 */
@Entity
@Table(name="expenses")
@NamedQuery(name="Expens.findAll", query="SELECT e FROM Expense e")
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="expense_doc_id", unique=true, nullable=false, length=100)
	private String expenseDocId;

	@Temporal(TemporalType.DATE)
	@Column(name="expense_acc_per_end")
	private Date expenseAccPerEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="expense_acc_per_start")
	private Date expenseAccPerStart;

	@Column(name="expense_description", length=200)
	private String expenseDescription;

	@Column(name="expense_doc_type", nullable=false)
	private Integer expenseDocType;

	@Temporal(TemporalType.DATE)
	@Column(name="expense_expiry_date")
	private Date expenseExpiryDate;

	@Column(name="expense_gross_amount", nullable=false, precision=131089)
	private BigDecimal expenseGrossAmount;

	@Column(name="expense_last_modified_dt")
	private Timestamp expenseLastModifiedDt;

	@Temporal(TemporalType.DATE)
	@Column(name="expense_payed_date")
	private Date expensePayedDate;

	@Column(name="expense_payment_method", nullable=false)
	private Integer expensePaymentMethod;

	@Temporal(TemporalType.DATE)
	@Column(name="expense_recieved_date", nullable=false)
	private Date expenseRecievedDate;

	//bi-directional many-to-one association to CostCenter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="expense_costcenter", nullable=false)
	private CostCenter costCenter;

	//bi-directional many-to-one association to ExpType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="expense_type", nullable=false)
	private ExpType expType;

	//bi-directional many-to-one association to Partner
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="expense_issuer", nullable=false)
	private Partner partner;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="expense_last_modified_by")
	private User user;

	public Expense() {
	}

	public String getExpenseDocId() {
		return this.expenseDocId;
	}

	public void setExpenseDocId(String expenseDocId) {
		this.expenseDocId = expenseDocId;
	}

	public Date getExpenseAccPerEnd() {
		return this.expenseAccPerEnd;
	}

	public void setExpenseAccPerEnd(Date expenseAccPerEnd) {
		this.expenseAccPerEnd = expenseAccPerEnd;
	}

	public Date getExpenseAccPerStart() {
		return this.expenseAccPerStart;
	}

	public void setExpenseAccPerStart(Date expenseAccPerStart) {
		this.expenseAccPerStart = expenseAccPerStart;
	}

	public String getExpenseDescription() {
		return this.expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public Integer getExpenseDocType() {
		return this.expenseDocType;
	}

	public void setExpenseDocType(Integer expenseDocType) {
		this.expenseDocType = expenseDocType;
	}

	public Date getExpenseExpiryDate() {
		return this.expenseExpiryDate;
	}

	public void setExpenseExpiryDate(Date expenseExpiryDate) {
		this.expenseExpiryDate = expenseExpiryDate;
	}

	public BigDecimal getExpenseGrossAmount() {
		return this.expenseGrossAmount;
	}

	public void setExpenseGrossAmount(BigDecimal expenseGrossAmount) {
		this.expenseGrossAmount = expenseGrossAmount;
	}

	public Timestamp getExpenseLastModifiedDt() {
		return this.expenseLastModifiedDt;
	}

	public void setExpenseLastModifiedDt(Timestamp expenseLastModifiedDt) {
		this.expenseLastModifiedDt = expenseLastModifiedDt;
	}

	public Date getExpensePayedDate() {
		return this.expensePayedDate;
	}

	public void setExpensePayedDate(Date expensePayedDate) {
		this.expensePayedDate = expensePayedDate;
	}

	public Integer getExpensePaymentMethod() {
		return this.expensePaymentMethod;
	}

	public void setExpensePaymentMethod(Integer expensePaymentMethod) {
		this.expensePaymentMethod = expensePaymentMethod;
	}

	public Date getExpenseRecievedDate() {
		return this.expenseRecievedDate;
	}

	public void setExpenseRecievedDate(Date expenseRecievedDate) {
		this.expenseRecievedDate = expenseRecievedDate;
	}

	public CostCenter getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public ExpType getExpType() {
		return this.expType;
	}

	public void setExpType(ExpType expType) {
		this.expType = expType;
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