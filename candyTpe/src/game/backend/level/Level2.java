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
        boolean aux = super.tryMove(i1, j1, i2, j2);
        // Si el movimiento es valido luego chequea el color de fondo de las posiciones
        int removeAmount = 0;
        Level2State state = (Level2State) state();
        if (aux){
            // si el movimiento es horizontal
            if (horizontalMove(i1, i2)){
                for (int k = 0; k <SIZE ; k++) {
                    if (super.g()[i2][k].getBackground()==null){
                        super.g()[i2][k].setBackground(Color.YELLOW);
                        removeAmount++;
                    }
                }
            }
            // if the column is the same
            else {
                for (int k = 0; k < SIZE; k++) {
                    if (super.g()[k][j1].getBackground()==null){
                        super.g()[k][j1].setBackground(Color.YELLOW);
                        removeAmount++;
                    }
                }
            }
        }
        state.decreaseGoldenRemaining(removeAmount);
        return aux;
    }

    public boolean horizontalMove(int i1, int i2) {
        return i1 - i2 == 0;
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

        void decreaseGoldenRemaining(int amount){
            golden_remaining -= amount;
        }
    }
}
