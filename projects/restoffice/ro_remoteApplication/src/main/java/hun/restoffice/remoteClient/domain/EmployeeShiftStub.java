package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for EmployeeShift
 *
 * @author kalmankostenszky
 */
public class EmployeeShiftStub implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final String name;
	private final String defaultPosition;
	private final Date atcualStart;
	private final Date actualEnd;
	private final String actualPosition;

	public EmployeeShiftStub(Date actualStart, Date actualEnd, String actualPosition, String employeeName, String defaultPosition) {

		this.name = employeeName;
		this.defaultPosition = defaultPosition;
		this.actualPosition = actualPosition;
		this.atcualStart = actualStart;
		this.actualEnd = actualEnd;
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
	public String getDefaultPosition() {
		return defaultPosition;
	}
	/**
	 * 
	 * @return the actualStart
	 */
	public Date getActualStart() {
		return atcualStart;
	}

	/**
	 * 
	 * @return the actualEnd
	 */
	public Date getActualEnd() {
		return actualEnd;
	}

	/**
	 * 
	 * @return the actualPosition
	 */
	public String getActualPosition() {
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
