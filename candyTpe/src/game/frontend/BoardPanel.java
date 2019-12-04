package game.frontend;

import game.backend.cell.Cell;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class BoardPanel extends TilePane {

	private ImageView[][] cells;

	public BoardPanel(final int rows, final int columns, final int cellSize) {
		setPrefRows(rows);
		setPrefColumns(columns);
		setPrefTileHeight(cellSize);
		setPrefTileWidth(cellSize);
		this.cells = new ImageView[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new ImageView();
				getChildren().add(cells[i][j]);
			}
		}
	}

	public void setImage(int row, int column, Image image, Color color) {

		if (color!=null){
			Light.Distant spotlight = new Light.Distant();
			spotlight.setColor(color);
			spotlight.setElevation(100);
			Lighting lighting = new Lighting(spotlight);
			cells[row][column].setEffect(lighting);
		}

        cells[row][column].setImage(image);


	}


}