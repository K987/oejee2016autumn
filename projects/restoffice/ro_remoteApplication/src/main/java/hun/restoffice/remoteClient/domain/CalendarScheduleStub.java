/**
 *
 */
package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;



/**
 * DTO for calendar schedule
 *
 * @author kalmankostenszky
 */

public class CalendarScheduleStub implements Comparable<CalendarScheduleStub>, Serializable {

    private final Calendar start;
    private final List<EmployeeShiftStub> assignees;

    private final int id;

    public CalendarScheduleStub(final Date startDate, final Date startTime, final int id, final List<EmployeeShiftStub> employeeShifts) {
        (start = Calendar.getInstance()).setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, startTime.getHours());
        start.set(Calendar.MINUTE, startTime.getMinutes());
        assignees = employeeShifts;
        this.id = id;

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
    public List<EmployeeShiftStub> getAssignees() {
        return assignees;
    }

    /**
     * @return the id
     */
    @JsonIgnore
    public int getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CalendarScheduleStub [id=" + id + ", start=" + String.format("%tc", start) + ", assignees=" + assignees
                +
                "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final CalendarScheduleStub o) {
        return start.compareTo(o.getStart());
    }





}


