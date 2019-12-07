package game.backend;

import game.backend.cell.Cell;
import game.backend.element.Element;
import game.backend.level.Levels;

public class CandyGame implements GameListener {
	// se actulizo el tipo para proteger el codigo y no que reciba cualquier clase
	private Class<? extends Levels> levelClass;
	private Grid grid;
	private GameState state;
	
	public CandyGame(Class<? extends  Levels> clazz) {
		this.levelClass = clazz;
	}



	public void initGame() {
		try {
			grid = levelClass.newInstance();
		} catch(IllegalAccessException | InstantiationException e) {
			System.out.println("ERROR AL INICIAR");
		}
		state = grid.createState();
		grid.initialize();
		addGameListener(this);
	}
	
	public int getSize() {
		return Grid.SIZE;
	}
	
	public boolean tryMove(int i1, int j1, int i2, int j2){
		return grid.tryMove(i1, j1, i2, j2);
	}

	public String getLevel(){return levelClass.cast(grid).getLevel_name();}

	public Cell get(int i, int j){
		return grid.getCell(i, j);
	}
	
	public void addGameListener(GameListener listener) {
		grid.addListener(listener);
	}
	
	public long getScore() {
		return state.getScore();
	}

	// Retorna el secondScore
	public String getSecondScore() { return state.getSecondScore(); }

	// Retorna si el nivel tiene dos scores
	public boolean isHasSecondScore() { return state.isHasSecondScore(); }

	// Retorna el string del secondLabel
	public String getSecondLabel() { return state.getSecondLabel(); }
	
	public boolean isFinished() {
		return state.gameOver();
	}
	
	public boolean playerWon() {
		return state.playerWon();
	}
	
	@Override
	public void cellExplosion(Element e) {
		state.addScore(e.getScore());
	}
	
	@Override
	public void gridUpdated() {
		//
	}
}
