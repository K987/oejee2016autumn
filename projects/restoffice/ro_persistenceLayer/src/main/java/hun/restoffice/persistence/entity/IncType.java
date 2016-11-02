package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the inc_types database table.
 * 
 */
@Entity
@Table(name="inc_types")
@NamedQuery(name=".findAll", query="SELECT i FROM  i")
public class IncType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INC_TYPES_INCTYPEID_GENERATOR", sequenceName="INC_TYPES_INC_TYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INC_TYPES_INCTYPEID_GENERATOR")
	@Column(name="inc_type_id")
	private Integer id;

	//TODO: set this unique in db
	@Column(name="inc_type_name", unique=true, nullable=false, length=100)
	private String name;

	@Column(name="inc_type_prod_related", nullable=false)
	private Boolean prodRelated;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="", fetch=FetchType.LAZY)
	private Set<Income> incomes;

	public IncType() {
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getProdRelated() {
		return this.prodRelated;
	}

	public void setProdRelated(Boolean prodRelated) {
		this.prodRelated = prodRelated;
	}

	public Set<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}

	public Income addIncome(Income income) {
		getIncomes().add(income);
		income.setIncType(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setIncType(null);

		return income;
	}

}