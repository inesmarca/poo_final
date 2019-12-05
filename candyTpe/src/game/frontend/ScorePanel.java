package game.frontend;

import game.backend.level.Level1;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	private Label scoreLabel;
	private Label secondLabel;
	private Label secondPoints;
	private Class<?> level;

	public ScorePanel(Class<?> level) {
		setStyle("-fx-background-color: #5490ff");
		scoreLabel = new Label("0");
		/**
		 *
		 */
		this.level = level;
		/**
		 *
		 */
		scoreLabel.setAlignment(Pos.CENTER);
		scoreLabel.setStyle("-fx-font-size: 24");
		setCenter(scoreLabel);
	}
	
	public void updateScore(String text) {
		scoreLabel.setText(text);
	}

	public void updateGolden(String text) {
	}
}