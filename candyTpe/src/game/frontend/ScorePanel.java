package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	private Label scoreLabel;
	private Label secondScore;
	private String secondTitle;

	// Recibe la variable que establece si el nivel tiene dos puntajes y la variable que con el titulo del segundo puntaje
	public ScorePanel(boolean hasSecondScore, String secondTitle) {
		this.secondTitle = secondTitle;
		setStyle("-fx-background-color: #5490ff");
		scoreLabel = new Label("Score: 0");

		scoreLabel.setAlignment(Pos.CENTER);
		scoreLabel.setStyle("-fx-font-size: 24");

		// Si el nivel tiene dos puntajes entonces cambia el formato del ScorePanel
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

	// Actualiza el valor del segundo puntaje
	public void updateSecondScore(String text) {
		secondScore.setText(String.format("%s %s", secondTitle, text));
	}
}