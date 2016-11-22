package hun.restoffice.client;

import java.io.IOException;

import org.apache.log4j.Logger;

import hun.restoffice.client.main.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEntry extends Application {

	private static final Logger LOG = Logger.getLogger(AppEntry.class);
	private Stage stage;
	private Parent root;

	private static final String[] uris = { "workday/DateView.fxml", //
			"register/RegisterCloseView.fxml", //
			"shift/ShiftView.fxml", //
			"dailyTransaction/DailyTransactionView.fxml" };

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.setTitle("Napi zárás");

		initLayout();
	}

	private void initLayout() {
		LOG.info("initlayout() invoked");

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AppEntry.class.getResource("main/MainView.fxml"));

			root = loader.load();
			MainController controller = loader.getController();

			Scene scene = new Scene(root);
			stage.setScene(scene);

			for (String uri : uris) {
				FXMLLoader tmp = new FXMLLoader();
				tmp.setLocation(AppEntry.class.getResource(uri));
				tmp.load();
				controller.addChild(tmp);
			}

			stage.show();
		} catch (IOException e) {
			LOG.error(e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}
}
