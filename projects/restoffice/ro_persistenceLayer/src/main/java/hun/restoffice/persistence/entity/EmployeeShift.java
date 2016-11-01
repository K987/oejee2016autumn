package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the employee_shift database table.
 * 
 */
@Entity
@Table(name="employee_shift")
@IdClass(EmployeeShiftId.class)
@NamedQuery(name="EmployeeShift.findAll", query="SELECT e FROM EmployeeShift e")
public class EmployeeShift implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Shift
	@Id
	@ManyToOne
	@JoinColumn(name="employee_shift_employee_id")
	private Employee employee;
	
	//bi-directional many-to-one association to Shift
	@Id
	@ManyToOne
	@JoinColumn(name="employee_shift_shift_id")
	private Shift shift;

	//TODO: set nullable true in DB
	@Column(name="employee_shift_actual_start")
	@Temporal(TemporalType.TIME)
	private Date actualStart;
	
	//TODO: set nullable true in DB
	@Column(name="employee_shift_actual_end")
	@Temporal(TemporalType.TIME)
	private Date actualEnd;

	//TODO: set position enum
	@Column(name="employee_shift_actual_position")
	private Integer actualPosition;

	@SequenceGenerator(name="employee_shift_employee_shift_id_generator", sequenceName="employee_shift_employee_shift_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_shift_employee_shift_id_generator")
	@Column(name="employee_shift_id", updatable=false)
	private Integer rowId;

	public Date getActualEnd() {
		return this.actualEnd;
	}

	public void setActualEnd(Date employeeShiftActualEnd) {
		this.actualEnd = employeeShiftActualEnd;
	}

	public Integer getActualPosition() {
		return this.actualPosition;
	}

	public void setActualPosition(Integer employeeShiftActualPosition) {
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