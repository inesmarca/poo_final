package game.backend.level;

import game.backend.GameState;

public class Level1 extends Levels {
	
	private static int REQUIRED_SCORE = 5000;
	private static int MAX_MOVES = 20;
	private static Integer INITIAL_VALUE = null;

	@Override
	public String getLevel_name() {
		return "Level 1";
	}

	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}
	
	private static class Level1State extends GameState {
		private long requiredScore;
		private long maxMoves;
		
		Level1State(long requiredScore, int maxMoves) {
			this.requiredScore = requiredScore;
			this.maxMoves = maxMoves;
			this.initialValue = INITIAL_VALUE;
		}
		
		public boolean gameOver() {
			return playerWon() || getMoves() >= maxMoves;
		}
		
		public boolean playerWon() {
			return getScore() > requiredScore;
		}
	}

}
