package hun.restoffice.persistence.entity.financialTransaction;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

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
@NamedQuery(name = "Expens.findAll", query = "SELECT e FROM Expense e")

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
@AssociationOverrides(value = {
		@AssociationOverride(name = "party", joinColumns = @JoinColumn(name = "expense_issuer")),
		@AssociationOverride(name = "lastModifiedBy", joinColumns = @JoinColumn(name = "expense_last_modified_by")) })
public class Expense extends FinancialTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	//fields
	
	// bi-directional many-to-one association to CostCenter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expense_costcenter", nullable = false)
	private CostCenter costCenter;

	// bi-directional many-to-one association to ExpType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expense_type", nullable = false)
	private ExpType expType;

	//constructors
	public Expense() {
	}

	//getters setters
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