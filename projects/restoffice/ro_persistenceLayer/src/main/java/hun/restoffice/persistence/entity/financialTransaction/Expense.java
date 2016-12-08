package hun.restoffice.persistence.entity.financialTransaction;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the expenses database table.
 * 
 */
/**
 * @author kalmankostenszky
 *
 */
@Entity
@Table(name = "expenses")
@NamedQueries(value = { 
		@NamedQuery(name = Expense.FIND_ALL, query = "SELECT e FROM Expense e JOIN FETCH  e.party"),
		@NamedQuery(name = Expense.READ_BY_DOC_ID, query = "SELECT e FROM Expense e WHERE LOWER(docId)=:" + Expense.DOC_ID),
		@NamedQuery(name = Expense.READ_FILTERED, query = "SELECT e FROM Expense e JOIN FETCH e.party WHERE "
				+ "1=1 "
				+ "AND (COALESCE(null, :"+Expense.PARTNER_ID+") is null OR e.party.id=:"+Expense.PARTNER_ID+") "
				+ "AND (COALESCE(null, :"+Expense.COSTCENTER_ID+") is null OR e.costCenter.id=:"+Expense.COSTCENTER_ID+") "
				+ "AND (COALESCE(null, :"+Expense.COSTTYPE_ID+") is null OR e.expType.id=:"+Expense.COSTTYPE_ID+") "
				+ "AND (COALESCE(null, :"+Expense.PAYMENT_METHOD+") is null OR e.payMethod=:"+Expense.PAYMENT_METHOD+") "
				+ "AND (COALESCE(null, :"+Expense.IS_PAYED+") is null OR e.payed is :"+Expense.IS_PAYED+")"
				)
})

@AttributeOverrides(value = { @AttributeOverride(name = "docId", column = @Column(name = "expense_doc_id")),
		@AttributeOverride(name = "docType", column = @Column(name = "expense_doc_type")),
		@AttributeOverride(name = "payMethod", column = @Column(name = "expense_payment_method")),
		@AttributeOverride(name = "grossTotal", column = @Column(name = "expense_gross_amount")),
		@AttributeOverride(name = "description", column = @Column(name = "expense_description")),
		@AttributeOverride(name = "registered", column = @Column(name = "expense_recieved_date")),
		@AttributeOverride(name = "expiry", column = @Column(name = "expense_expiry_date")),
		@AttributeOverride(name = "payed", column = @Column(name = "expense_payed_date")),
		@AttributeOverride(name = "accPeriod.startDate", column = @Column(name = "expense_acc_per_start")),
		@AttributeOverride(name = "accPeriod.endDate", column = @Column(name = "expense_acc_per_end")),
		@AttributeOverride(name = "lastModifiedAt", column = @Column(name = "expense_last_modified_dt")) })
@AssociationOverrides(value = { @AssociationOverride(name = "party", joinColumns = @JoinColumn(name = "expense_issuer", referencedColumnName = "partner_id")),
		@AssociationOverride(name = "lastModifiedBy", joinColumns = @JoinColumn(name = "expense_last_modified_by", referencedColumnName = "user_id")) })
public class Expense extends FinancialTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Expense.findAll";
	public static final String READ_BY_DOC_ID = "Expense.readById";
	public static final String READ_FILTERED = "Expense.readFiltered";

	public static final String DOC_ID = "docId";
	public static final String PARTNER_ID = "partnerId";
	public static final String COSTCENTER_ID = "costCenterId";
	public static final String COSTTYPE_ID = "costTypeId";
	public static final String PAYMENT_METHOD = "paymentMethod";
	public static final String IS_PAYED = "isPayed";

	// fields

	// bi-directional many-to-one association to CostCenter
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "expense_costcenter", nullable = false, referencedColumnName = "cost_center_id")
	private CostCenter costCenter;

	// bi-directional many-to-one association to ExpType
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "expense_type", nullable = false, referencedColumnName = "exp_type_id")
	private ExpType expType;

	// constructors
	public Expense() {
	}

	// getters setters
	/**
	 * @return
	 */
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

	/**
	 * turns gt 0 to lt 0
	 */
	@Override
	public void setGrossTotal(BigDecimal grossTotal) {
		if (grossTotal.compareTo(new BigDecimal(0)) == 1)
			grossTotal.negate();
		super.setGrossTotal(grossTotal);
	}

}