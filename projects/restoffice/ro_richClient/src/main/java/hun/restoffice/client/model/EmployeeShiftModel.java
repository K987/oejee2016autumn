package hun.restoffice.client.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;

public class EmployeeShiftModel {

	
	private ObservableStringValue name;
	private ObservableValue<PositonType> defaultPosition;
	private ObservableValue<LocalTime> defaultStart;
	private SimpleObjectProperty<PositonType> actualPosition;
	private SimpleObjectProperty<LocalDateTime> actualStart;
	private SimpleObjectProperty<LocalDateTime> actualEnd;
	private Calendar start;
	
	public EmployeeShiftModel(String name, String defaultPosition, String actualPosition, Calendar actualStart, Calendar actualEnd, Calendar start) {
		
		this.name = new ReadOnlyStringWrapper(name);
		this.defaultPosition = new ReadOnlyObjectWrapper<>(PositonType.valueOf(defaultPosition));
		this.actualPosition = new SimpleObjectProperty<>();
		this.start = start;
		
		if (actualPosition == null || actualPosition.equals(""))
			this.actualPosition.set(PositonType.valueOf(defaultPosition));
		else
			this.actualPosition.set(PositonType.valueOf(actualPosition));
		
		this.actualStart = new SimpleObjectProperty<>();
		this.actualEnd = new SimpleObjectProperty<>();
		
		if (actualStart == null || actualStart.getTime() == null)
			this.actualStart.set(LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault()));
		else
			this.actualStart.set(LocalDateTime.ofInstant(actualStart.toInstant(), ZoneId.systemDefault()));
		
		this.defaultStart = new ReadOnlyObjectWrapper<>(this.actualStart.get().toLocalTime());
		
		if (actualEnd == null || actualEnd.getTime() == null)
			this.actualEnd.set(this.actualStart.getValue());
		else
			this.actualEnd.set(LocalDateTime.ofInstant(actualEnd.toInstant(), ZoneId.systemDefault()));
	}

	public ObservableStringValue nameProperty() {
		return name;
	}

	public  ObservableValue<PositonType> defaultPositionProperty() {
		return defaultPosition;
	}
	
	public  ObservableValue<LocalTime> defaultStartProperty() {
		return defaultStart;
	}

	public SimpleObjectProperty<PositonType> actualPositionProperty() {
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
		return String.format("EmployeeShiftModel [name=%s, defaultPosition=%s, actualPosition=%s, actualStart=%s, actualEnd=%s]", name.get(), defaultPosition.getValue(),
				actualPosition.get(), actualStart.get(), actualEnd.get());
	}
	
	
}
