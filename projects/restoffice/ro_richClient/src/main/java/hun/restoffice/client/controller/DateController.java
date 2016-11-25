/**
 * 
 */
package hun.restoffice.client.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import hun.restoffice.client.converter.Converter;
import hun.restoffice.client.model.EmployeeShiftModel;
import hun.restoffice.client.service.RemoteServiceFactory;
import hun.restoffice.remoteClient.domain.EmployeeShiftStub;
import hun.restoffice.remoteClient.service.FacadeException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private ListView<EmployeeShiftModel> employees;
	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onNext()
	 */

	private Calendar selectedDate;

	public DateController() {

	}

	@FXML
	private void initialize() {
		datePicker.setValue(LocalDate.now());
	}

	@Override
	public void onNext() {
		LOG.debug("onNext() invoked");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onPrevious()
	 */
	@Override
	public void onPrevious() {
		LOG.debug("onPrevious() invoked");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onCancel()
	 */
	@Override
	public void onCancel() {
		LOG.debug("onCancel() invoked");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onSend()
	 */
	@Override
	public void onSend() {
		LOG.debug("onSend() invoked");

	}

	@FXML
	private void onDateSelected() {
		LOG.debug("date selected :" + datePicker.getValue());
		LocalDate localDate = datePicker.getValue();
		Calendar cal = Calendar.getInstance();
		cal.setTime(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

		try {
			employees.setItems(Converter.to(RemoteServiceFactory.lookup().getCalendarschedule(cal)));
		} catch (FacadeException e) {
			LOG.error(e);
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Hiba történt az alkalmazottak ellenõzése közben");
			alert.showAndWait();
		} catch (NamingException e) {
			LOG.error(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.controller.WizardElement#onLoad()
	 */
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub

	}

	public Calendar getSelectedDate() {
		return selectedDate;
	}
}
