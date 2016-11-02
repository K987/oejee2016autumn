package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the exp_types database table.
 * 
 */
@Entity
@Table(name="exp_types")
@NamedQuery(name="ExpType.findAll", query="SELECT e FROM ExpType e")
public class ExpType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXP_TYPES_EXPTYPEID_GENERATOR", sequenceName="EXP_TYPES_EXP_TYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXP_TYPES_EXPTYPEID_GENERATOR")
	@Column(name="exp_type_id")
	private Integer id;

	//TODO: set this to unique in the database as well
	@Column(name="exp_type_name", nullable=false, unique=true, length=100)
	private String name;

	@Column(name="exp_type_prod_related", nullable=false)
	private Boolean prodRelated;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="", fetch=FetchType.LAZY)
	private Set<Expense> expenses;

	public ExpType() {
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setExpTypeName(String name) {
		this.name = name;
	}

	public Boolean getProdRelated() {
		return this.prodRelated;
	}

	public void setProdRelated(Boolean prodRelated) {
		this.prodRelated = prodRelated;
	}

	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpense(Expense expense) {
		getExpenses().add(expense);
		expense.setExpType(this);

		return expense;
	}

	public Expense removeExpense(Expense expense) {
		getExpenses().remove(expense);
		expense.setExpType(null);

		return expense;
	}

}