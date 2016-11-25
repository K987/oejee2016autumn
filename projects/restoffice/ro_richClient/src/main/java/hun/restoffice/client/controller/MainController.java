/**
 * 
 */
package hun.restoffice.client.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class MainController {

	private static final Logger LOG = Logger.getLogger(MainController.class);

	private List<FXMLLoader> elements;

	private int selectedItem = -1;
	private WizardElement selectedController;

	@FXML
	private Button cancel;

	@FXML
	private Button previous;

	@FXML
	private Button next;

	@FXML
	private Button send;

	@FXML
	private VBox advanceIndicator;

	@FXML
	private BorderPane pane;

	public MainController(List<URL> urls) {
		elements = new ArrayList<>();
		for (URL location : urls) {
			elements.add(new FXMLLoader(location));
		}
		if (!elements.isEmpty())
			selectedItem = 0;
	}

	@FXML
	public void initialize() {
		setPane(selectedItem);
	}

	/**
	 * @param actualElement2
	 */
	private void setPane(int actualElement2) {
		if (selectedItem < 0 || selectedItem >= elements.size()){
			LOG.error("No wizard elements set");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Nap zárás nem elérhetzõ");
			alert.showAndWait();
			System.exit(-1);
		}
			

		FXMLLoader tmp = elements.get(actualElement2);

		if (tmp.getRoot() == null) {
			try {
				tmp.load();
			} catch (IOException e) {
				LOG.error(e);
			}
		}

		pane.setCenter(tmp.getRoot());
		selectedController = tmp.getController();
		pane.requestLayout();
	}

	@FXML
	private void onCancel() {
		LOG.debug("cancel pressed");
		selectedItem = 0;
		setPane(selectedItem);
		setAdvanceIndicator(selectedItem);
	}

	@FXML
	private void onPrevoius() {
		LOG.debug("previous pressed");
		if (selectedItem > 1) {
			setPane(--selectedItem);
			setAdvanceIndicator(selectedItem);
		}
	}

	@FXML
	private void onNext() {
		LOG.debug("next pressed");
		if (selectedItem < elements.size() - 1) {
			setPane(++selectedItem);
			setAdvanceIndicator(selectedItem);
		}
	}

	@FXML
	private void onSend() {
		LOG.debug("send pressed");
	}

	/**
	 * @param selectedItem2
	 */
	private void setAdvanceIndicator(int selectedItem2) {
		ObservableList<Node> labels = advanceIndicator.getChildren();
		for (int i = 0; i < labels.size(); i++) {
			if (i == selectedItem2) {
				((Label) labels.get(i)).setStyle("-fx-background-color: greenyellow;");
			} else if (i < selectedItem2) {
				((Label) labels.get(i)).setStyle("-fx-background-color: limegreen;");
			} else {
				((Label) labels.get(i)).setStyle("-fx-background-color: salmon;");
			}
		}
	}
}
