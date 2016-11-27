package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.util.Date;

public class EmployeeShiftStub implements Serializable{

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

	public String getName() {
		return name;
	}

	public String getDefaultPosition() {
		return defaultPosition;
	}

	public Date getActualStart() {
		return atcualStart;
	}

	public Date getActualEnd() {
		return actualEnd;
	}

	public String getActualPosition() {
		return actualPosition;
	}

	@Override
	public String toString() {
		return String.format("EmployeeShiftStub [name=%s, defaultPosition=%s, acutalStart=%s, actualEnd=%s, actualPosition=%s]", name, defaultPosition,
				atcualStart, actualEnd, actualPosition);
	}
	

	
}
