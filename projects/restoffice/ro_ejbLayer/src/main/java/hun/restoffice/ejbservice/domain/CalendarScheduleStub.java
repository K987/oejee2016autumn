/**
 * 
 */
package hun.restoffice.ejbservice.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import hun.restoffice.persistence.entity.employee.EmployeeShift;
import hun.restoffice.persistence.entity.employee.JobPosition;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class CalendarScheduleStub {

	private final Calendar start;
	private final List<Assignee> assignees; 
	/**
	 * @param startDate
	 * @param startTime
	 * @param employeeShifts
	 */
	public CalendarScheduleStub(Date startDate, Date startTime, Set<EmployeeShift> employeeShifts) {
		start = Calendar.getInstance();
		start.setTime(startDate);
		start.set(Calendar.HOUR_OF_DAY, startTime.getHours());
		start.set(Calendar.MINUTE, startTime.getMinutes());
		
		assignees = new ArrayList<>();
		for (EmployeeShift es : employeeShifts) {
			assignees.add(new Assignee(es));
		}
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("CalendarScheduleStub [start=%s, assignees=%s]", start, assignees);
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




	private class Assignee{

		private final String name;
		private final JobPosition defaultPosition;
		private final Calendar acutalStart;
		private final Calendar actualEnd;
		private final JobPosition actualPosition;

		/**
		 * @param es
		 */
		public Assignee(EmployeeShift es) {
			this.name = es.getEmployee().getEmployeeName();
			this.defaultPosition = es.getEmployee().getDefaultPosition();
			if (es.getActualStart() != null){
				this.acutalStart = (Calendar) start.clone();
				this.acutalStart.set(Calendar.HOUR_OF_DAY, es.getActualStart().getHours());
				this.acutalStart.set(Calendar.MINUTE, es.getActualStart().getMinutes());
			} else
				this.acutalStart = null;
			
			if(es.getActualEnd() != null){
				this.actualEnd = (Calendar) start.clone();
				this.actualEnd.set(Calendar.HOUR_OF_DAY, es.getActualEnd().getHours());
				this.actualEnd.set(Calendar.MINUTE, es.getActualEnd().getMinutes());
			} else
				this.actualEnd = null;
			
			
			this.actualPosition = es.getActualPosition() != null ? es.getActualPosition() : null;
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
		public JobPosition getDefaultPosition() {
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
		public JobPosition getActualPosition() {
			return actualPosition;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("Assignee [name=%s, defaultPosition=%s, acutalStart=%s, actualEnd=%s, actualPosition=%s]", name, defaultPosition, acutalStart,
					actualEnd, actualPosition);
		}
		
		
		
		
		
	}

}
