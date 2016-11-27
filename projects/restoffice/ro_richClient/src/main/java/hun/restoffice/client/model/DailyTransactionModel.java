/**
 * 
 */
package hun.restoffice.client.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableStringValue;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class DailyTransactionModel {
	
	private DoubleProperty posAmt;
	private DoubleProperty cardAmt;
	private DoubleProperty cashAmt;
	
	private EmployeeShiftModel employeeModel;

	public DailyTransactionModel(EmployeeShiftModel esm){
		employeeModel = esm;
		posAmt = new SimpleDoubleProperty(0);
		cardAmt = new SimpleDoubleProperty(0);
		cashAmt = new SimpleDoubleProperty(0);	
	}

	/**
	 * @return the posAmt
	 */
	public DoubleProperty posAmtProperty() {
		return posAmt;
	}

	/**
	 * @return the cardAmt
	 */
	public DoubleProperty cardAmtProperty() {
		return cardAmt;
	}

	/**
	 * @return the cashAmt
	 */
	public DoubleProperty cashAmtProperty() {
		return cashAmt;
	}

	/**
	 * @return the model
	 */
	public EmployeeShiftModel employeeModelProperty() {
		return employeeModel;
	}
	
	public ObservableStringValue employeeNameProperty(){
		return employeeModel.nameProperty();
	}
	
	public SimpleObjectProperty<PositonType> employeeActPosProperty(){
		return employeeModel.actualPositionProperty();
	}
	
	
	

}
