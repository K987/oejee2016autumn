/**
 * 
 */
package hun.restoffice.client.workday;

import java.time.LocalDate;

import org.apache.log4j.Logger;

import hun.restoffice.client.main.WizardElement;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class DateController implements WizardElement {

	private static final Logger LOG = Logger.getLogger(DateController.class);
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private ListView<EmployeeStub> employees;
	/* (non-Javadoc)
	 * @see hun.restoffice.client.main.WizardElement#onNext()
	 */
	
	public DateController(){
		
	}
	
	@FXML
	private void initialize() {
		datePicker.setValue(LocalDate.now());
	}
	
	@Override
	public void onNext() {
		LOG.debug("onNext() invoked"); 

	}

	/* (non-Javadoc)
	 * @see hun.restoffice.client.main.WizardElement#onPrevious()
	 */
	@Override
	public void onPrevious() {
		LOG.debug("onPrevious() invoked"); 

	}

	/* (non-Javadoc)
	 * @see hun.restoffice.client.main.WizardElement#onCancel()
	 */
	@Override
	public void onCancel() {
		LOG.debug("onCancel() invoked");

	}

	/* (non-Javadoc)
	 * @see hun.restoffice.client.main.WizardElement#onSend()
	 */
	@Override
	public void onSend() {
		LOG.debug("onSend() invoked");

	}

	@FXML
	private void onDateSelected(){
		LOG.debug("date selected :"+ datePicker.getValue());
		
	}
}
