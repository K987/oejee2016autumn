package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * DTO for EmployeeShift
 *
 * @author kalmankostenszky
 */
public class EmployeeShiftStub implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final int defaultPosition;
    private Calendar atcualStart;
    private Calendar actualEnd;
    private int actualPosition;

    private int shiftId;
    private final int rowId;

    public EmployeeShiftStub(final Date actualStart, final Integer rowId, final Date actualEnd,
            final int actualPosition, final String employeeName, final int defaultPosition) {

        name = employeeName;
        this.defaultPosition = defaultPosition;
        this.actualPosition = actualPosition;
        if (actualStart != null)
            (atcualStart = Calendar.getInstance()).setTime(actualStart);
        else
            atcualStart = null;
        if (actualEnd != null)
            (this.actualEnd = Calendar.getInstance()).setTime(actualEnd);
        else
            this.actualEnd = null;

        this.rowId = rowId;
        shiftId = -1;
    }

    /**
     * @param name
     * @param shiftId
     * @param actualStart
     * @param actualEnd
     * @param actualPosition
     */
    public EmployeeShiftStub(final String name, final int shiftId, final int rowId, final Date actualStart,
            final Date actualEnd, final int actualPosition) {
        this(actualStart, rowId, actualEnd, actualPosition, name, -1);
        this.shiftId = shiftId;
    }

    /**
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the defaultPosition
     */
    @JsonIgnore
    public int getDefaultPosition() {
        return defaultPosition;
    }

    /**
     *
     * @return the actualStart
     */
    public Calendar getActualStart() {
        return atcualStart;
    }

    /**
     *
     * @return the actualEnd
     */
    public Calendar getActualEnd() {
        return actualEnd;
    }

    /**
     * @return the shiftid
     */
    @JsonIgnore
    public int getShiftid() {
        return shiftId;
    }

    /**
     *
     * @return the actualPosition
     */
    @JsonIgnore
    public int getActualPosition() {
        return actualPosition;
    }

    /**
     * @return the rowId
     */
    @JsonIgnore
    public int getRowId() {
        return rowId;
    }

    @JsonGetter("defaultPosition")
    public String getTheDefaultPosition() {
        switch (defaultPosition) {
            case 0:
                return "waiter";
            case 1:
                return "bartender";
            case 2:
                return "chef";
            case -1:
            default:
                return "unknown";
        }
    }

    @JsonGetter("acutalPosition")
    public String getTheActualPosition() {
        switch (actualPosition) {
            case 0:
                return "waiter";
            case 1:
                return "bartender";
            case 2:
                return "chef";
            case -1:
            default:
                return "unknown";
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EmployeeShiftStub [name=" + name + ", defaultPosition=" + defaultPosition + ", atcualStart="
                + String.format("%tc", atcualStart) + ", actualEnd=" + String.format("%tc", actualEnd)
                + ", actualPosition=" + actualPosition + ", shiftId=" + shiftId + ", rowId=" + rowId + "]";
    }

}
