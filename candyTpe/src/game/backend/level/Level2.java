package game.backend.level;

import game.backend.GameState;

import javafx.scene.paint.Color;



public class Level2 extends Level1 {





    @Override
    protected GameState newState() {
        return new Level2State(MAX_MOVES);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
        }
        // checks the background color, if its null changes it to golden.
        if (ret){
            //if the row is the same
            if (i1-i2==0){
                for (int j = 0; j <SIZE ; j++) {
                    Level2State state = (Level2State) state();
                    if (super.g()[i2][j].getBackground()==null){
                        super.g()[i2][j].setBackground(Color.YELLOW);
                        state.decreaseGoldenRemaining();
                    }
                }
            }
            // if the column is the same
            else {
                for (int i = 0; i < SIZE; i++) {
                    Level2State state = (Level2State) state();
                    if (super.g()[i][j1].getBackground()==null){
                        super.g()[i][j1].setBackground(Color.YELLOW);
                        state.decreaseGoldenRemaining();
                    }
                }
            }

        }
        return ret;
    }

    private static class Level2State extends GameState {
        private long maxMoves;
        private int golden_remaining;

        Level2State(int maxMoves) {
            this.maxMoves = maxMoves;
            this.golden_remaining=SIZE*SIZE;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return golden_remaining==0;
        }

        void decreaseGoldenRemaining(){
        golden_remaining--;

        }
    }
}
