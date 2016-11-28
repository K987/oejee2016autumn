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

/*
 * Model class for EmployeeShift 
 */
public class EmployeeShiftModel {

	private ObservableStringValue name;
	private ObservableValue<PositonType> defaultPosition;
	private ObservableValue<LocalTime> defaultStart;
	private SimpleObjectProperty<PositonType> actualPosition;
	private SimpleObjectProperty<LocalDateTime> actualStart;
	private SimpleObjectProperty<LocalDateTime> actualEnd;
	private Calendar start;
	
	/**
	 * 
	 * @param name
	 * @param defaultPosition
	 * @param actualPosition
	 * @param actualStart
	 * @param actualEnd
	 * @param start
	 */
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

	/**
	 * @return the name
	 */
	public ObservableStringValue nameProperty() {
		return name;
	}

	/**
	 * @return the defaultPosition
	 */
	public  ObservableValue<PositonType> defaultPositionProperty() {
		return defaultPosition;
	}
	
	/**
	 * @return the defaultStart
	 */
	public  ObservableValue<LocalTime> defaultStartProperty() {
		return defaultStart;
	}

	/**
	 * @return the actualPosition
	 */
	public SimpleObjectProperty<PositonType> actualPositionProperty() {
		return actualPosition;
	}

	/**
	 * @return the actaulStart
	 */
	public SimpleObjectProperty<LocalDateTime> actualStartProperty() {
		return actualStart;
	}

	/**
	 * @return the actualEnd
	 */
	public SimpleObjectProperty<LocalDateTime> actualEndProperty() {
		return actualEnd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("EmployeeShiftModel [name=%s, defaultPosition=%s, actualPosition=%s, actualStart=%s, actualEnd=%s]", name.get(), defaultPosition.getValue(),
				actualPosition.get(), actualStart.get(), actualEnd.get());
	}
	
	
}
