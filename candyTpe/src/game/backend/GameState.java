package game.backend;

public abstract class GameState {
	
	private long score = 0;
	private int moves = 0;
	// se agregaron estas variables para poder mostrarlas en Scorepanel
	protected boolean hasSecondScore = false;
	protected String secondLabel;
	protected long secondScore;
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}

	public void addMove() {
		moves++;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

	// retorna el segundo score
	public String getSecondScore() { return ((Long)secondScore).toString(); }

	// retorna si el nivel tiene dos scores
	public boolean isHasSecondScore() { return hasSecondScore; }
	//retorna el string que precede al puntaje, el contexto que le da sentido al puntaje secundario.
	//"Bomb Timer:" para el nivel 3
	public String getSecondLabel() { return secondLabel; }
}
