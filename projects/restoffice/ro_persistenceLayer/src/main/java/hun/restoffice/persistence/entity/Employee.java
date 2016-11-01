package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName="EMPLOYEES_EMPLOYEE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEES_EMPLOYEEID_GENERATOR")
	@Column(name="employee_id")
	private Integer id;

	@Column(name="employee_active", nullable=false)
	private Boolean active;

	@Column(name="employee_default_hourly_wage")
	private BigDecimal defaultHourlyWage;

	//TODO: add enum 
	@Column(name="employee_default_position", nullable=false)
	private Integer defaultPosition;

	@Column(name="employee_name", nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to EmployeeShift
	@OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
	private Set<EmployeeShift> employeeShifts;

	public Employee() {
	}

	public Integer getId() {
		return this.id;
	}

	public Boolean IsActive() {
		return this.active;
	}

	public void setActive(Boolean employeeActive) {
		this.active = employeeActive;
	}

	public BigDecimal getDefaultHourlyWage() {
		return this.defaultHourlyWage;
	}

	public void setDefaultHourlyWage(BigDecimal employeeDefaultHourlyWage) {
		this.defaultHourlyWage = employeeDefaultHourlyWage;
	}

	public Integer getDefaultPosition() {
		return this.defaultPosition;
	}

	public void setDefaultPosition(Integer employeeDefaultPosition) {
		this.defaultPosition = employeeDefaultPosition;
	}

	public String getEmployeeName() {
		return this.name;
	}

	public void setEmployeeName(String employeeName) {
		this.name = employeeName;
	}

	public Set<EmployeeShift> getEmployeeShifts() {
		return this.employeeShifts;
	}

	public void setEmployeeShifts(Set<EmployeeShift> employeeShifts) {
		this.employeeShifts = employeeShifts;
	}

	/**
	 * 
	 * @param employeeShift
	 * @return
	 */
	public EmployeeShift addEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().add(employeeShift);
		employeeShift.setEmployee(this);

		return employeeShift;
	}

	public EmployeeShift removeEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().remove(employeeShift);
		employeeShift.setEmployee(null);

		return employeeShift;
	}

}