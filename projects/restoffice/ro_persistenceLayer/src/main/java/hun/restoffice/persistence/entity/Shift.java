package hun.restoffice.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the shifts database table.
 * 
 * revised: 16.11.01
 * TODO: maybe set to composite key start date and start time
 */
@Entity
@Table(name="shifts")
@NamedQuery(name="Shift.findAll", query="SELECT s FROM Shift s")
public class Shift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIFTS_SHIFTID_GENERATOR", sequenceName="SHIFTS_SHIFT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIFTS_SHIFTID_GENERATOR")
	@Column(name="shift_id")
	private Integer id;

	@Column(name="shift_duration", nullable=false)
	private BigDecimal duration;

	@Temporal(TemporalType.DATE)
	@Column(name="shift_start_d", nullable=false)
	private Date startDate;

	@Temporal(TemporalType.TIME)
	@Column(name="shift_start_t", nullable=false)
	private Date startTime;

	//bi-directional many-to-one association to EmployeeShift
	@OneToMany(mappedBy="shift")
	private Set<EmployeeShift> employeeShifts;

	public Shift() {
	}

	public Integer getId() {
		return this.id;
	}

	public BigDecimal getDuration() {
		return this.duration;
	}

	public void setDuration(BigDecimal shiftDuration) {
		this.duration = shiftDuration;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date shiftStartD) {
		this.startDate = shiftStartD;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date shiftStartT) {
		this.startTime = shiftStartT;
	}

	public Set<EmployeeShift> getEmployeeShifts() {
		return this.employeeShifts;
	}

	public void setEmployeeShifts(Set<EmployeeShift> employeeShifts) {
		this.employeeShifts = employeeShifts;
	}

	public EmployeeShift addEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().add(employeeShift);
		employeeShift.setShift(this);

		return employeeShift;
	}

	public EmployeeShift removeEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().remove(employeeShift);
		employeeShift.setShift(null);

		return employeeShift;
	}

}