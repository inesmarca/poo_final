package game.frontend;

import game.backend.CandyGame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	private Label scoreLabel;
	private Label secondScore;
	private String secondTitle;

	public ScorePanel(boolean hasSecondScore, String secondTitle) {
		this.secondTitle = secondTitle;
		setStyle("-fx-background-color: #5490ff");
		scoreLabel = new Label("Score: 0");

		scoreLabel.setAlignment(Pos.CENTER);
		scoreLabel.setStyle("-fx-font-size: 24");
		if (hasSecondScore) {
			secondScore = new Label();
			secondScore.setStyle("-fx-font-size: 24");
			setLeft(scoreLabel);
			setRight(secondScore);
		} else {
			setCenter(scoreLabel);
		}
	}
	
	public void updateScore(String text) {
		scoreLabel.setText(String.format("Score: %s", text));
	}

	public void updateSecondScore(String text) {
		secondScore.setText(String.format("%s %s", secondTitle, text));
	}
}