package game.backend.level;

import game.backend.GameState;

public class Level3 extends Levels {

    private static int REQUIRED_SCORE = 5000;
   private static int MAX_MOVES = 20;


    @Override
    protected GameState newState() {
        return new Level3.Level3State(REQUIRED_SCORE, MAX_MOVES);
    }

    private class Level3State extends GameState {
        private long requiredScore;
        private long maxMoves;
        private boolean bomb_exploded;

        private Level3State(long requiredScore, int maxMoves) {
            this.requiredScore = requiredScore;
            this.maxMoves = maxMoves;
            this.bomb_exploded=false;
        }


        @Override
        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        @Override
        public boolean playerWon() {
            return getScore() > requiredScore && !bomb_exploded;
        }
    }
}
