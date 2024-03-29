package game.frontend;

import game.backend.CandyGame;
import game.backend.GameListener;
import game.backend.cell.Cell;
import game.backend.element.Element;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CandyFrame extends VBox {

	private static final int CELL_SIZE = 65;

	private BoardPanel boardPanel;
	private ScorePanel scorePanel;
	private ImageManager images;
	private Point2D lastPoint;
	private CandyGame game;

	// Los paremtros window y rootScene son usados para la creacion del boton "Atras"
	public CandyFrame(CandyGame game, Stage window, Scene rootScene) {
		this.game = game;
		// Se le manda el stage y scene del menu
		getChildren().add(new AppMenu(window, rootScene));
		images = new ImageManager();
		boardPanel = new BoardPanel(game.getSize(), game.getSize(), CELL_SIZE);
		getChildren().add(boardPanel);
		// Sino no se puede usar valores iniciales del nivel
		game.initGame();

		scorePanel = new ScorePanel(game().isHasSecondScore(), game().getSecondLabel());
		getChildren().add(scorePanel);

		if (game().isHasSecondScore()) {
			scorePanel.updateSecondScore(game().getSecondScore());
		}

		GameListener listener;
		game.addGameListener(listener = new GameListener() {
			@Override
			public void gridUpdated() {
				Timeline timeLine = new Timeline();
				Duration frameGap = Duration.millis(100);
				Duration frameTime = Duration.ZERO;
				for (int i = game().getSize() - 1; i >= 0; i--) {
					for (int j = game().getSize() - 1; j >= 0; j--) {
						int finalI = i;
						int finalJ = j;
						Cell cell = CandyFrame.this.game.get(i, j);
						Element element = cell.getContent();
						Image image = images.getImage(element);
						/* cambio en el codigo, esto nos permite actualizar el valor de el background.
						  mandamos la celda para que la funcion tenga informacion sobre que color mostrar.
						 */

                        // este codigo pregunta al tipe element si es que tiene algun mensaje para mostrar.
						// de ser asi, tomamos el mensaje y lo mandamos al set image para actualizar la pantalla.

						timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, null, null,null)));
                        timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, image, cell.getBackground(),cell.getContent().DisplayText())));






					}
					frameTime = frameTime.add(frameGap);
				}
				timeLine.play();



			}
			@Override
			public void cellExplosion(Element e) {
				//
			}
		});

		listener.gridUpdated();


		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (lastPoint == null) {
				lastPoint = translateCoords(event.getX(), event.getY());
				System.out.println("Get first = " +  lastPoint);
			} else {
				Point2D newPoint = translateCoords(event.getX(), event.getY());
				if (newPoint != null) {
					System.out.println("Get second = " +  newPoint);
					game().tryMove((int)lastPoint.getX(), (int)lastPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());
					String message = ((Long)game().getScore()).toString();
					if (game().isFinished()) {
						if (game().playerWon()) {
							message = message + " Finished - Player Won!";
						} else {
							message = message + " Finished - Loser !";
						}
					}
					scorePanel.updateScore(message);
					if (game().isHasSecondScore()) {
						scorePanel.updateSecondScore(game().getSecondScore());
					}

					lastPoint = null;
				}
			}
		});

	}

	private CandyGame game() {
		return game;
	}

	private Point2D translateCoords(double x, double y) {
		double i = x / CELL_SIZE;
		double j = y / CELL_SIZE;
		return (i >= 0 && i < game.getSize() && j >= 0 && j < game.getSize()) ? new Point2D(j, i) : null;
	}

}
