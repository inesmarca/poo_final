package game.frontend;

import game.backend.CandyGame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	private Label scoreLabel;
	private Label secondScore;

	public ScorePanel(Integer initialValue) {
		setStyle("-fx-background-color: #5490ff");
		scoreLabel = new Label("0");

		scoreLabel.setAlignment(Pos.CENTER);
		scoreLabel.setStyle("-fx-font-size: 24");
		secondScore = new Label(initialValue.toString());
		secondScore.setStyle("-fx-font-size: 24");
		setLeft(scoreLabel);
		setRight(secondScore);

	}
	
	public void updateScore(String text) {
		scoreLabel.setText(text);
	}

	public void updateSecondScore(String text) {
		secondScore.setText(text);
	}
}