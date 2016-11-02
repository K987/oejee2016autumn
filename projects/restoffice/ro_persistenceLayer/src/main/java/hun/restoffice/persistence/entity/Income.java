package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the incomes database table.
 * 
 * revised
 */
@Entity
@Table(name="incomes")
@NamedQuery(name="Income.findAll", query="SELECT i FROM Income i")
@AttributeOverrides(value = { 
		@AttributeOverride(name="docId", column=@Column(name="income_doc_id")),
		@AttributeOverride(name="docType", column=@Column(name="income_doc_type")),
		@AttributeOverride(name="payMethod", column=@Column(name="income_payment_method")),
		@AttributeOverride(name="grossTotal", column=@Column(name="income_gross_amount")),
		@AttributeOverride(name="description", column=@Column(name="income_description")),
		@AttributeOverride(name="registered", column=@Column(name="income_issue_date")),
		@AttributeOverride(name="expiry", column=@Column(name="income_expiry_date")),
		@AttributeOverride(name="payed", column=@Column(name="income_payed_date")),
		@AttributeOverride(name="accPeriod.startDate", column=@Column(name="income_acc_per_start")),
		@AttributeOverride(name="accPeriod.endDate", column=@Column(name="income_acc_per_end")),
		@AttributeOverride(name="lastModifiedAt", column=@Column(name="income_last_modified_dt"))
})
@AssociationOverrides(value = { 
		@AssociationOverride(name="party", joinColumns=@JoinColumn(name="income_liable")),
		@AssociationOverride(name="lastModifiedBy", joinColumns=@JoinColumn(name="income_last_modified_by"))
})
public class Income implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to IncType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="income_type", nullable=false)
	private IncType incType;

	public Income() {
	}


	public IncType getIncType() {
		return this.incType;
	}

	public void setIncType(IncType incType) {
		this.incType = incType;
	}
}