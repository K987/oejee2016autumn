/**
 * 
 */
package hun.restoffice.client.register;

import java.util.Calendar;

import org.apache.log4j.Logger;

import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class RegisterModel {

	private static final Logger LOG = Logger.getLogger(RegisterModel.class);

	private StringProperty id;
	private StringProperty type;
	private Calendar date;

	private IntegerProperty closeNo;
	private DoubleProperty amount;

	private BooleanProperty used;
	
	public RegisterModel() {

	}

	public RegisterModel(RegisterCloseStub regClose) {

		this.id = new SimpleStringProperty(regClose.getId());
		this.type = new SimpleStringProperty(regClose.getType().toString());

		this.date = regClose.getDate();
		this.closeNo = new SimpleIntegerProperty(regClose.getCloseNo());
		this.amount = new SimpleDoubleProperty(regClose.getAmt().doubleValue());
		this.used = new SimpleBooleanProperty(false);
	}
	

	/**
	 * @return the id
	 */
	public StringProperty idProperty() {
		return id;
	}

	/**
	 * @return the type
	 */
	public StringProperty typeProperty() {
		return type;
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @return the closeNo
	 */
	public IntegerProperty closeNoProperty() {
		return closeNo;
	}

	/**
	 * @return the amount
	 */
	public DoubleProperty amountProperty() {
		return amount;
	}

	
	/**
	 * @return the used
	 */
	public BooleanProperty usedProperty() {
		return used;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("RegisterModel [id=%s, type=%s, date=%s, closeNo=%s, amount=%s, isUsed=%s]", id.get(), type.get(), date.get(Calendar.HOUR_OF_DAY),
				closeNo.get(), amount.get(), used.get());
	}

}
