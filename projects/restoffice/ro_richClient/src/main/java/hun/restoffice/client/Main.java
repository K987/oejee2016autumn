package hun.restoffice.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import hun.restoffice.client.register.RegisterCloseController;
import hun.restoffice.client.register.RegisterCloseModel;
import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import hun.restoffice.remoteClient.domain.RegisterType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static final Logger LOG = Logger.getLogger(Main.class);
	private Stage stage;
	private BorderPane root;

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.setTitle("fő ablak");

		initLayout();
	}

	/**
	 * 
	 */
	private void initLayout() {
		LOG.info("initlayout() invoked");

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("register/RegisterCloseView.fxml"));
			root = (BorderPane) loader.load();

			RegisterCloseController controller = loader.getController();
			controller.setMain(this);

			Scene scene = new Scene(root);
			stage.setScene(scene);
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

	static RegisterCloseModel rcm;

	/**
	 * @return
	 */
	public static RegisterCloseModel getRegisterData() {

		List<RegisterCloseStub> tmp = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			RegisterType tp = RegisterType.CASH;
			if (i % 2 == 0) {
				tp = RegisterType.CARD;
			}
			tmp.add(new RegisterCloseStub(new BigDecimal(0), new Date(), Integer.toString(i), i * 10, tp));
		}

		rcm = new RegisterCloseModel(tmp);

		return rcm;

	}


}
