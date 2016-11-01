package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the cost_centers database table.
 * 
 */
@Entity
@Table(name="cost_centers")
//TODO: add static final fields for qry name and parameters
@NamedQueries({ 
	@NamedQuery(name = "CostCenter.findAll", query = "SELECT c FROM CostCenter c")
})
public class CostCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	//fields
	@Id
	@SequenceGenerator(name="COST_CENTERS_COSTCENTERID_GENERATOR", sequenceName="COST_CENTERS_COST_CENTER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COST_CENTERS_COSTCENTERID_GENERATOR")
	@Column(name="cost_center_id")
	private Integer id;

	@Column(name="cost_center_default", nullable=false)
	private Boolean defaultCostCenter;

	//TODO: set this to unique in the database as well
	@Column(name="cost_center_name", nullable=false, unique=true, length=100)
	private String name;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="costCenter", fetch=FetchType.LAZY)
	private Set<Expense> expenses;

	//ctors
	
	public CostCenter() {
	}

	//getters and setters
	
	public Integer getId() {
		return this.id;
	}

	public Boolean isDefault() {
		return this.defaultCostCenter;
	}

	//TODO: if true set this cost center to default and set previous default to false
	public void setDefault(Boolean costCenterDefault) {
		
		this.defaultCostCenter = costCenterDefault;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String costCenterName) {
		this.name = costCenterName;
	}

	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	/**
	 * set an expense to this cost center
	 * @param expense to be added
	 * @return the added expense
	 */
	public Expense addExpense(Expense expense) {
		getExpenses().add(expense);
		expense.setCostCenter(this);

		return expense;
	}

	/**
	 * Remove an expense from cost center
	 * @param expense to be removed
	 * @return removed expense
	 */
	public Expense removeExpense(Expense expense) {
		getExpenses().remove(expense);
		expense.setCostCenter(null);

		return expense;
	}

}