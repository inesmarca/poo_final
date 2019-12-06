package game.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {
	Stage window;
	Scene scene1;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws IOException {
		this.window = primaryStage;

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("sample.fxml"));
		Parent root = loader.load();

		scene1 = new Scene(root, 500, 600);
		((Controller) loader.getController()).setPrimaryStage(window).setRootScene(scene1);

		window.setTitle("Candy Crush");
		window.setResizable(false);
		window.setScene(scene1);
		window.show();

	}
}
