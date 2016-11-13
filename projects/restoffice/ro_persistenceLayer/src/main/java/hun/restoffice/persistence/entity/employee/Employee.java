package hun.restoffice.persistence.entity.employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the employees database table.
 * 
 * @author kalmankostenszky
 */
@Entity
@Table(name = "employees")
@NamedQueries(value = {
		@NamedQuery(name = Employee.FIND_ALL, query = "SELECT e FROM Employee e"), 
		@NamedQuery(name = Employee.GET_EMPLOYEE_SCHEDULE, query = "SELECT e FROM Employee e LEFT JOIN FETCH e.employeeShifts es LEFT JOIN FETCH es.shift s "
				+ "WHERE e.name=:"+Employee.NAME+" AND s.startDate BETWEEN :"+Employee.START_DATE+" AND :"+Employee.END_DATE)
		})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Employee.findAll";
	public static final String GET_EMPLOYEE_SCHEDULE = "Employee.getSchedule";
	
	public static final String NAME = "name";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";

	// fields

	@Id
	@SequenceGenerator(name = "EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName = "EMPLOYEES_EMPLOYEE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_EMPLOYEEID_GENERATOR")
	@Column(name = "employee_id")
	private Integer id;

	@Column(name = "employee_active", nullable = false)
	private Boolean active;

	@Column(name = "employee_default_hourly_wage")
	private BigDecimal defaultHourlyWage;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "employee_default_position", nullable = false)
	private JobPosition defaultPosition;

	@Column(name = "employee_name", nullable = false, length = 100)
	private String name;

	// bi-directional many-to-one association to EmployeeShift
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, targetEntity = EmployeeShift.class)
	private Set<EmployeeShift> employeeShifts;

	// constructors

	public Employee() {
	}

	// public methods

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

	// getters setters
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

	public JobPosition getDefaultPosition() {
		return this.defaultPosition;
	}

	public void setDefaultPosition(JobPosition employeeDefaultPosition) {
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

}