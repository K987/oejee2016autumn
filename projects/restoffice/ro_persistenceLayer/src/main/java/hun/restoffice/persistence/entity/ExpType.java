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
	@Column(name="exp_type_id", updatable=false, unique=true, nullable=false)
	private Integer expTypeId;

	@Column(name="exp_type_name", nullable=false, length=100)
	private String expTypeName;

	@Column(name="exp_type_prod_related", nullable=false)
	private Boolean expTypeProdRelated;

	//bi-directional many-to-one association to Expens
	@OneToMany(mappedBy="expType")
	private Set<Expense> expenses;

	public ExpType() {
	}

	private Integer getExpTypeId() {
		return this.expTypeId;
	}

	public void setExpTypeId(Integer expTypeId) {
		this.expTypeId = expTypeId;
	}

	public String getExpTypeName() {
		return this.expTypeName;
	}

	public void setExpTypeName(String expTypeName) {
		this.expTypeName = expTypeName;
	}

	public Boolean getExpTypeProdRelated() {
		return this.expTypeProdRelated;
	}

	public void setExpTypeProdRelated(Boolean expTypeProdRelated) {
		this.expTypeProdRelated = expTypeProdRelated;
	}

	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setExpType(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setExpType(null);

		return expens;
	}

}