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
@NamedQuery(name="IncType.findAll", query="SELECT i FROM IncType i")
public class IncType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INC_TYPES_INCTYPEID_GENERATOR", sequenceName="INC_TYPES_INC_TYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INC_TYPES_INCTYPEID_GENERATOR")
	@Column(name="inc_type_id", updatable=false, unique=true, nullable=false)
	private Integer incTypeId;

	@Column(name="inc_type_name", nullable=false, length=100)
	private String incTypeName;

	@Column(name="inc_type_prod_related", nullable=false)
	private Boolean incTypeProdRelated;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="incType")
	private Set<Income> incomes;

	public IncType() {
	}

	public Integer getIncTypeId() {
		return this.incTypeId;
	}

	private void setIncTypeId(Integer incTypeId) {
		this.incTypeId = incTypeId;
	}

	public String getIncTypeName() {
		return this.incTypeName;
	}

	public void setIncTypeName(String incTypeName) {
		this.incTypeName = incTypeName;
	}

	public Boolean getIncTypeProdRelated() {
		return this.incTypeProdRelated;
	}

	public void setIncTypeProdRelated(Boolean incTypeProdRelated) {
		this.incTypeProdRelated = incTypeProdRelated;
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