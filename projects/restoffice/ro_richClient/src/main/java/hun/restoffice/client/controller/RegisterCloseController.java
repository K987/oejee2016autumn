/**
 * 
 */
package hun.restoffice.client.controller;

import java.text.NumberFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import hun.restoffice.client.AppEntry;
import hun.restoffice.client.model.RegisterCloseModel;
import hun.restoffice.client.model.RegisterModel;
import hun.restoffice.client.service.RemoteServiceFactory;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.CurrencyStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class RegisterCloseController implements WizardElement {

	private static final Logger LOG = Logger.getLogger(RegisterCloseController.class);

	private static final String SUM_COL = "Z összeg";
	private static final String CLOSE_NO_COL = "Z szám";

	@FXML
	private TableView<RegisterModel> registerTable;

	@FXML
	private TableColumn<RegisterModel, String> idCol;

	@FXML
	private TableColumn<RegisterModel, String> typeCol;

	@FXML
	private TableColumn<RegisterModel, Number> closeNoCol;

	@FXML
	private TableColumn<RegisterModel, Number> amtCol;

	@FXML
	private TableColumn<RegisterModel, Boolean> usedCol;

	@FXML
	private Label cashLbl;

	@FXML
	private Label cardLbl;

	@FXML
	private Label sumLabel;

	private AppEntry main;

	public RegisterCloseController() {

	}

	@FXML
	private void initialize() {
		LOG.debug("initialize called");

		closeNoCol.setText(CLOSE_NO_COL);
		amtCol.setText(SUM_COL);
		/*
		 * idCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RegisterModel, String>,
		 * ObservableValue<String>>() {
		 * 
		 * @Override public ObservableValue<String> call(CellDataFeatures<RegisterModel, String> cellData) { return
		 * cellData.getValue().idProerty(); } });
		 */

		idCol.setCellValueFactory(new PropertyValueFactory<RegisterModel, String>("id"));
		typeCol.setCellValueFactory(new PropertyValueFactory<RegisterModel, String>("type"));
		closeNoCol.setCellValueFactory(new PropertyValueFactory<RegisterModel, Number>("closeNo"));
		amtCol.setCellValueFactory(new PropertyValueFactory<RegisterModel, Number>("amount"));
		usedCol.setCellValueFactory(new PropertyValueFactory<RegisterModel, Boolean>("used"));

		final NumberFormat nf = NumberFormat.getInstance();
		nf.setParseIntegerOnly(true);

		closeNoCol.setCellFactory(tableColumn -> {
			final DynamicEditableTextTableCell<RegisterModel, Number> cell = new DynamicEditableTextTableCell<>(//
					new NumberStringConverter(nf));

			cell.recordProperty().addListener((ChangeListener<RegisterModel>) (ov, vOld, vNew) -> {
				cell.editableProperty().unbind();
				if (vNew != null)
					cell.editableProperty().bind(vNew.usedProperty());
			});
			return cell;
		});

		amtCol.setCellFactory(tableColumn -> {
			final DynamicEditableTextTableCell<RegisterModel, Number> cell = new DynamicEditableTextTableCell<>(//
					new CurrencyStringConverter());

			cell.recordProperty().addListener((ChangeListener<RegisterModel>) (ov, vOld, vNew) -> {
				cell.editableProperty().unbind();
				if (vNew != null)
					cell.editableProperty().bind(vNew.usedProperty());
			});
			return cell;
		});

		usedCol.setCellFactory(CheckBoxTableCell.forTableColumn(usedCol));
	}

	@FXML
	public void handleNumberChange(CellEditEvent<RegisterModel, Number> event) {
		RegisterModel toChange = event.getTableView().getItems().get(event.getTablePosition().getRow());
		switch (event.getTableColumn().getText()) {
			case CLOSE_NO_COL: {
				toChange.closeNoProperty().setValue(event.getNewValue());
				LOG.debug(toChange.toString());
				break;
			}
			case SUM_COL: {
				toChange.amountProperty().setValue(event.getNewValue());
				LOG.debug(toChange.toString());
				break;
			}
		}
	}

	/**
	 * @param main
	 *            the main to set
	 */
	RegisterCloseModel rcm;

	public void setMain(AppEntry main) {
		this.main = main;

		registerTable.setItems(rcm.getRegModels());

		for (final RegisterModel rm : registerTable.getItems()) {

			rm.usedProperty().addListener((ChangeListener<Boolean>) (paramObservableValue, paramT1, paramT2) -> {
				if (paramT2 != null && !paramT2) {
					rm.amountProperty().set(0);
				}
			});
		}
		cardLbl.textProperty().bind(Bindings.format("%.1f Ft", rcm.getCard()));
		cashLbl.textProperty().bind(Bindings.format("%.1f Ft", rcm.getCash()));
		sumLabel.textProperty().bind(Bindings.format("%.1f Ft", rcm.getSum()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onNext()
	 */
	@Override
	public void onNext() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onPrevious()
	 */
	@Override
	public void onPrevious() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onCancel()
	 */
	@Override
	public void onCancel() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.main.WizardElement#onSend()
	 */
	@Override
	public void onSend() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.client.controller.WizardElement#onLoad()
	 */
	@Override
	public void onLoad() {
		
		RemoteServiceFactory.lookup().getRegistersToClose(Calendar.getInstance());
	}

}
