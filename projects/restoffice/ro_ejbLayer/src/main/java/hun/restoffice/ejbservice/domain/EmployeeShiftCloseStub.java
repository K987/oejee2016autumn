package hun.restoffice.ejbservice.domain;

import java.util.Calendar;

import hun.restoffice.persistence.entity.employee.JobPosition;

/**
 *
 */
public class EmployeeShiftCloseStub {

    private final int shiftId;
    private final int employeeShiftId;
    private final int employeeId;
    private final String employeeName;
    private final Calendar actualStart;
    private final Calendar actualEnd;
    private final JobPosition defaultPosition;
    private final JobPosition actualPosition;
    private boolean closed;

    /**
     * @param shiftId
     * @param employeeShiftId
     * @param employeeId
     * @param employeeName
     * @param actualStart
     * @param actualEnd
     * @param actualPosition
     */
    public EmployeeShiftCloseStub(final int shiftId, final int employeeShiftId, final int employeeId,
            final String employeeName, final Calendar actualStart, final Calendar actualEnd,
            final JobPosition actualPosition, final JobPosition defaultPosition, final boolean closed) {
        super();
        this.shiftId = shiftId;
        this.employeeShiftId = employeeShiftId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.actualStart = actualStart;
        this.actualEnd = actualEnd;
        this.actualPosition = actualPosition;
        this.defaultPosition = defaultPosition;
        this.closed = closed;
    }

    /**
     * @return the shiftId
     */
    public int getShiftId() {
        return shiftId;
    }

    /**
     * @return the employeeShiftId
     */
    public int getEmployeeShiftId() {
        return employeeShiftId;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @return the actualStart
     */
    public Calendar getActualStart() {
        return actualStart;
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

    /**
     * @return the defaultPosition
     */
    public JobPosition getDefaultPosition() {
        return defaultPosition;
    }

    /**
     * @return the closed
     */
    public boolean isClosed() {
        return closed;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EmployeeShiftCloseStub [shiftId=" + shiftId + ", employeeShiftId=" + employeeShiftId + ", employeeId="
                + employeeId + ", employeeName=" + employeeName + ", actualStart=" + String.format("%tc", actualStart)
                + ", actualEnd=" + String.format("%tc", actualEnd) + ", actualPosition=" + actualPosition + "]";
    }
}
