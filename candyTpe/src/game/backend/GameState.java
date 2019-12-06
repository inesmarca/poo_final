package game.backend;

public abstract class GameState {
	
	private long score = 0;
	private int moves = 0;
	protected long secondScore;
	protected Integer initialValue;
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}

	// retorna el segundo score
	public String getSecondScore() { return ((Long)secondScore).toString(); }
	
	public void addMove() {
		moves++;
	}
	
	public int getMoves() { return moves; }

	public Integer getInitialValue() { return initialValue; }
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

}
