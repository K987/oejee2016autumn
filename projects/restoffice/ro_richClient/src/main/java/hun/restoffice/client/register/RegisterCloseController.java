/**
 * 
 */
package hun.restoffice.client.register;

import java.text.NumberFormat;

import org.apache.log4j.Logger;

import hun.restoffice.client.Main;
import hun.restoffice.client.util.DynamicEditableTextTableCell;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.converter.CurrencyStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class RegisterCloseController {

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

	private Main main;

	public RegisterCloseController() {

	}

	
	@FXML
	private void initialize() {

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
		closeNoCol.setCellFactory(new Callback<TableColumn<RegisterModel, Number>, TableCell<RegisterModel, Number>>() {
			/* (non-Javadoc)
			 * @see javafx.util.Callback#call(java.lang.Object)
			 */
			@Override
			public TableCell<RegisterModel, Number> call(TableColumn<RegisterModel, Number> tableColumn) {
			  final DynamicEditableTextTableCell<RegisterModel, Number> cell = new DynamicEditableTextTableCell<>(
			    new NumberStringConverter(nf));
			  cell.recordProperty().addListener(new ChangeListener<RegisterModel>() {
				/* (non-Javadoc)
				 * @see javafx.beans.value.ChangeListener#changed(javafx.beans.value.ObservableValue, java.lang.Object, java.lang.Object)
				 */
				@Override
				public void changed(ObservableValue<? extends RegisterModel> ov, RegisterModel vOld, RegisterModel vNew) {
				    cell.editableProperty().unbind();
				    if (vNew != null)
				      cell.editableProperty().bind(vNew.usedProperty());
				  }
			});
			  return cell;
			}
		});		
		
	    amtCol.setCellFactory(new Callback<TableColumn<RegisterModel, Number>, TableCell<RegisterModel, Number>>() {
			/* (non-Javadoc)
			 * @see javafx.util.Callback#call(java.lang.Object)
			 */
			@Override
			public TableCell<RegisterModel, Number> call(TableColumn<RegisterModel, Number> tableColumn) {
			  final DynamicEditableTextTableCell<RegisterModel, Number> cell = new DynamicEditableTextTableCell<>(
			    new CurrencyStringConverter());
			  cell.recordProperty().addListener(new ChangeListener<RegisterModel>() {
				/* (non-Javadoc)
				 * @see javafx.beans.value.ChangeListener#changed(javafx.beans.value.ObservableValue, java.lang.Object, java.lang.Object)
				 */
				@Override
				public void changed(ObservableValue<? extends RegisterModel> ov, RegisterModel vOld, RegisterModel vNew) {
				    cell.editableProperty().unbind();
				    if (vNew != null)
				      cell.editableProperty().bind(vNew.usedProperty());
				  }
			});
			  return cell;
			}
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

	public void setMain(Main main) {
		this.main = main;
		rcm = Main.getRegisterData();

		
		registerTable.setItems(rcm.getRegModels());

		for ( final RegisterModel rm : registerTable.getItems()) {

			rm.usedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> paramObservableValue, Boolean paramT1, Boolean paramT2) {
					if (paramT2 != null && !paramT2){
						rm.amountProperty().set(0);
					}
				}
			});
		}
		cardLbl.textProperty().bind(Bindings.format("%.1f Ft", rcm.getCard()));
		cashLbl.textProperty().bind(Bindings.format("%.1f Ft", rcm.getCash()));
		sumLabel.textProperty().bind(Bindings.format("%.1f Ft", rcm.getSum()));

	}

}
