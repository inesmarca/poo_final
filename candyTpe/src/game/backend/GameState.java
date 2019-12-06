package game.backend;

public abstract class GameState {
	
	private long score = 0;
	private int moves = 0;
	private int secondScore;
	private long initialValue;
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}

	// retorna el segundo score
	public long getSecondScore() { return secondScore; }
	
	public void addMove() {
		moves++;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

}
