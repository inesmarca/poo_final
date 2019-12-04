package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		primaryStage.setTitle("Candy Crush");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, 500, 600));
		primaryStage.show();

		/**
		 CandyGame game = new CandyGame(Level1.class);
		 CandyFrame frame = new CandyFrame(game);
		 Scene scene = new Scene(frame);
		 primaryStage.setResizable(false);
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 */


	}


	public void Level1(ActionEvent actionEvent) {
		selectLevel(Level1.class);
	}

	public void Level2(ActionEvent actionEvent) {
	}

	public void Level3(ActionEvent actionEvent) {
	}

	public void selectLevel(Class<?> level) {
		Stage secondStage = new Stage();
		CandyGame game = new CandyGame(level);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		secondStage.setResizable(false);
		secondStage.setScene(scene);
		secondStage.show();
	}

}
