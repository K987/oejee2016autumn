package hun.restoffice.client.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableStringValue;

public class EmployeeShiftModel {

	
	private ObservableStringValue name;
	private ObservableStringValue defaultPosition;
	private SimpleStringProperty actualPosition;
	private SimpleObjectProperty<LocalDateTime> actualStart;
	private SimpleObjectProperty<LocalDateTime> actualEnd;
	private LocalDate start;
	
	public EmployeeShiftModel(String name, String defaultPosition, String actualPosition, Calendar actualStart, Calendar actualEnd, Calendar start) {
		
		this.name = new ReadOnlyStringWrapper(name);
		this.defaultPosition = new ReadOnlyStringWrapper(defaultPosition);
		this.actualPosition = new SimpleStringProperty();
		
		if (actualPosition == null || actualPosition.equals(""))
			this.actualPosition.set(defaultPosition);
		else
			this.actualPosition.set(actualPosition);
		
		this.actualStart = new SimpleObjectProperty<LocalDateTime>();
		
		if (actualStart == null || actualStart.getTime() == null)
			this.actualStart.set(LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault()));
		else
			this.actualStart.set(LocalDateTime.ofInstant(actualStart.toInstant(), ZoneId.systemDefault()));
		
		if (actualEnd == null || actualEnd.getTime() == null)
			this.actualEnd.set(this.actualStart.getValue());
		else
			this.actualEnd.set(LocalDateTime.ofInstant(actualEnd.toInstant(), ZoneId.systemDefault()));
	}

	public ObservableStringValue nameProperty() {
		return name;
	}

	public ObservableStringValue defaultPositionProperty() {
		return defaultPosition;
	}

	public SimpleStringProperty actualPositionProperty() {
		return actualPosition;
	}

	public SimpleObjectProperty<LocalDateTime> actualStartProperty() {
		return actualStart;
	}

	public SimpleObjectProperty<LocalDateTime> actualEndProperty() {
		return actualEnd;
	}

	@Override
	public String toString() {
		return String.format("EmployeeShiftModel [name=%s, defaultPosition=%s, actualPosition=%s, actualStart=%s, actualEnd=%s]", name.get(), defaultPosition.get(),
				actualPosition.get(), actualStart.get(), actualEnd.get());
	}
	
	
}
