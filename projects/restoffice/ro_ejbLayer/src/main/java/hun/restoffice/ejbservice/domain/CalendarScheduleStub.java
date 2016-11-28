/**
 * 
 */
package hun.restoffice.ejbservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hun.restoffice.persistence.entity.employee.JobPosition;
import hun.restoffice.remoteClient.domain.EmployeeShiftStub;

/**
 * DTO for calendar schedule
 *
 * @author kalmankostenszky
 */
public class CalendarScheduleStub implements Comparable<CalendarScheduleStub>, Serializable {

	private final Calendar start;
	private final List<Assignee> assignees;

	public CalendarScheduleStub(Date startDate, Date startTime, int id, List<EmployeeShiftStub> employeeShifts) {
		(start = Calendar.getInstance()).set(startDate.getYear(), startDate.getMonth(), startDate.getDay(), startDate.getHours(), startDate.getMinutes());
		assignees = new ArrayList<>();
		for (EmployeeShiftStub es : employeeShifts) {
			assignees.add(new Assignee(es));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("CalendarScheduleStub [start=%s, assignees=%s]", start, assignees);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CalendarScheduleStub o) {
		return start.compareTo(o.getStart());
	}

	/**
	 * @return the start
	 */
	public Calendar getStart() {
		return start;
	}

	/**
	 * @return the assignees
	 */
	public List<Assignee> getAssignees() {
		return assignees;
	}

	public class Assignee implements Comparable<Assignee>, Serializable {

		private final String name;
		private final Calendar acutalStart;
		private final Calendar actualEnd;
		private final JobPosition defaultPoistion;

		public Assignee(EmployeeShiftStub employeeShift) {
			this.name = employeeShift.getName();
			this.acutalStart = employeeShift.getActualStart();
			this.actualEnd = employeeShift.getActualEnd();
			this.defaultPoistion = JobPosition.values()[employeeShift.getDefaultPosition()];
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the acutalStart
		 */
		public Calendar getAcutalStart() {
			return acutalStart;
		}

		/**
		 * @return the actualEnd
		 */
		public Calendar getActualEnd() {
			return actualEnd;
		}

		
		/**
		 * @return the defaultPoistion
		 */
		public JobPosition getDefaultPoistion() {
			return defaultPoistion;
		}


		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("Assignee [name=%s, defaultPosition=%s, acutalStart=%s, actualEnd=%s]", name, defaultPoistion, acutalStart, actualEnd);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Assignee o) {
			return this.defaultPoistion.compareTo(o.defaultPoistion) * 10 +  this.name.compareTo(o.getName());
		}

	}
}
