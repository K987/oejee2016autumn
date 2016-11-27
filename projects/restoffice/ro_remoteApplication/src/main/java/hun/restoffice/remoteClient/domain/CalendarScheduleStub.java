/**
 * 
 */
package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * DTO for calendar schedule
 *
 * @author kalmankostenszky
 */
public class CalendarScheduleStub implements Comparable<CalendarScheduleStub>, Serializable {

	private final Calendar start;
	private final List<Assignee> assignees;

	public CalendarScheduleStub(Date startDate, Date startTime, List<EmployeeShiftStub> employeeShifts) {
		start = Calendar.getInstance();
		start.setTime(startDate);
		start.set(Calendar.HOUR_OF_DAY, startTime.getHours());
		start.set(Calendar.MINUTE, startTime.getMinutes());

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
		private final String defaultPosition;
		private final Calendar acutalStart;
		private final Calendar actualEnd;
		private final String actualPosition;

		public Assignee(EmployeeShiftStub employeeShift) {
			this.name = employeeShift.getName();
			this.defaultPosition = employeeShift.getDefaultPosition();
			if (employeeShift.getActualStart() != null) {
				this.acutalStart = (Calendar) start.clone();
				this.acutalStart.set(Calendar.HOUR_OF_DAY, employeeShift.getActualStart().getHours());
				this.acutalStart.set(Calendar.MINUTE, employeeShift.getActualStart().getMinutes());
			} else
				this.acutalStart = null;

			if (employeeShift.getActualEnd() != null) {
				this.actualEnd = (Calendar) start.clone();
				this.actualEnd.set(Calendar.HOUR_OF_DAY, employeeShift.getActualEnd().getHours());
				this.actualEnd.set(Calendar.MINUTE, employeeShift.getActualEnd().getMinutes());
			} else
				this.actualEnd = null;

			this.actualPosition = employeeShift.getActualPosition() != null ? employeeShift.getActualPosition() : null;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the defaultPosition
		 */
		public String getDefaultPosition() {
			return defaultPosition;
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
		 * @return the actualPosition
		 */
		public String getActualPosition() {
			return actualPosition;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("Assignee [name=%s, defaultPosition=%s, acutalStart=%s, actualEnd=%s, actualPosition=%s]", name, defaultPosition, acutalStart,
					actualEnd, actualPosition);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Assignee o) {
			return this.defaultPosition.compareTo(o.getDefaultPosition()) * 10 + this.name.compareTo(o.getName());
		}

	}
}
