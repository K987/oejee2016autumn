package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the daily_incomes database table.
 * 
 */
@Entity
@Table(name="daily_incomes")
//TODO: add static final fields for qry name and params
@NamedQueries({ 
	@NamedQuery(name = "DailyIncome.findAll", query = "SELECT d FROM DailyIncome d")
})
public class DailyIncome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DAILY_INCOMES_DAILYINCOMEID_GENERATOR", sequenceName="DAILY_INCOMES_DAILY_INCOME_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DAILY_INCOMES_DAILYINCOMEID_GENERATOR")
	@Column(name="daily_income_id")
	private Integer id;

	@Column(name="daily_income_card")
	private BigDecimal cardSum;

	@Column(name="daily_income_cash")
	private BigDecimal cashSum;

	//TODO: add not nullable in DB
	@OneToOne
	@JoinColumn(name="daily_income_employee_shift", nullable=false)
	private EmployeeShift dailyIncomeEmployeeShift;

	@Column(name="daily_pos_sum", nullable=false)
	private BigDecimal posSum;

	public DailyIncome() {
	}

	public Integer getId() {
		return this.id;
	}

	public BigDecimal getCardSum() {
		return this.cardSum;
	}

	public void setCardSum(BigDecimal dailyIncomeCard) {
		this.cardSum = dailyIncomeCard;
	}

	public BigDecimal getCashSum() {
		return this.cashSum;
	}

	public void setCashSum(BigDecimal dailyIncomeCash) {
		this.cashSum = dailyIncomeCash;
	}

	public EmployeeShift getEmployeeShift() {
		return this.dailyIncomeEmployeeShift;
	}
	//TODO: set map connection vica-versa
	public void setEmployeeShift(EmployeeShift dailyIncomeEmployeeShift) {
		this.dailyIncomeEmployeeShift = dailyIncomeEmployeeShift;
	}

	public BigDecimal getPosSum() {
		return this.posSum;
	}

	public void setPosSum(BigDecimal dailyPosSum) {
		this.posSum = dailyPosSum;
	}

}