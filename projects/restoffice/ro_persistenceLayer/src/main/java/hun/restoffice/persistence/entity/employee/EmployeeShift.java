package hun.restoffice.persistence.entity.employee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the employee_shift database table.
 * 
 * @author kalmankostenszky
 */
@Entity
@Table(name = "employee_shift")
@IdClass(EmployeeShiftId.class)
@NamedQueries(value = { @NamedQuery(name = "EmployeeShift.findAll", query = "SELECT es FROM EmployeeShift es"),
		@NamedQuery(name = EmployeeShift.GET_ENTITES, query = "SELECT es FROM EmployeeShift es  WHERE employee=:" + EmployeeShift.EMPLOYEE
				+ " AND shift.startDate >TO_DATE(:" + EmployeeShift.FROM_DATE+" , 'YYYY-MM-DD')") })
public class EmployeeShift implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String GET_ENTITES = "EmployeeShift.getEntites";

	public static final String EMPLOYEE = "employee";
	public static final String FROM_DATE = "fromDate";

	// bi-directional many-to-one association to Shift
	@Id
	@ManyToOne
	@JoinColumn(name = "employee_shift_employee_id", referencedColumnName = "employee_id")
	private Employee employee;

	// bi-directional many-to-one association to Shift
	@Id
	@ManyToOne
	@JoinColumn(name = "employee_shift_shift_id", referencedColumnName = "shift_id")
	private Shift shift;

	// TODO: set nullable true in DB
	@Column(name = "employee_shift_actual_start")
	@Temporal(TemporalType.TIME)
	private Date actualStart;

	// TODO: set nullable true in DB
	@Column(name = "employee_shift_actual_end")
	@Temporal(TemporalType.TIME)
	private Date actualEnd;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "employee_shift_actual_position")
	private JobPosition actualPosition;

	@SequenceGenerator(name = "employee_shift_employee_shift_id_generator", sequenceName = "employee_shift_employee_shift_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_shift_employee_shift_id_generator")
	@Column(name = "employee_shift_id", updatable = false)
	private Integer rowId;

	public Date getActualEnd() {
		return this.actualEnd;
	}

	public void setActualEnd(Date employeeShiftActualEnd) {
		this.actualEnd = employeeShiftActualEnd;
	}

	public JobPosition getActualPosition() {
		return this.actualPosition;
	}

	public void setActualPosition(JobPosition employeeShiftActualPosition) {
		this.actualPosition = employeeShiftActualPosition;
	}

	public Date getActualStart() {
		return this.actualStart;
	}

	public void setActualStart(Date employeeShiftActualStart) {
		this.actualStart = employeeShiftActualStart;
	}

	public Integer getRowId() {
		return this.rowId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		employee.addEmployeeShift(this);
	}

	public Shift getShift() {
		return this.shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
		shift.addEmployeeShift(this);
	}

}