package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * DTO for EmployeeShift
 *
 * @author kalmankostenszky
 */
public class EmployeeShiftStub implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final String name;
	private final int defaultPosition;
	private final Calendar atcualStart;
	private final Calendar actualEnd;
	private final int actualPosition;

	public EmployeeShiftStub(Date actualStart, Date actualEnd, int actualPosition, String employeeName, int defaultPosition) {

		this.name = employeeName;
		this.defaultPosition = defaultPosition;
		this.actualPosition = actualPosition;
		if (actualStart != null)
		(this.atcualStart = Calendar.getInstance()).setTime(actualStart);
		else
			this.atcualStart = null;
		if (actualEnd != null)
		(this.actualEnd = Calendar.getInstance()).setTime(actualEnd);
		else
			this.actualEnd = null;
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
	 * 
	 * @return the actualPosition
	 */
	public int getActualPosition() {
		return actualPosition;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("EmployeeShiftStub [name=%s, defaultPosition=%s, acutalStart=%s, actualEnd=%s, actualPosition=%s]", name, defaultPosition,
				atcualStart, actualEnd, actualPosition);
	}
	

	
}
