package game.backend.level;

import game.backend.GameState;
import javafx.scene.paint.Color;

// la clase level2 modela el golden board

public class Level2 extends Levels {

    private static int MAX_MOVES = 20;
    // son strings para poblar el scorepanel
    private static long INITIAL_VALUE = SIZE * SIZE;
    private static String SECOND_LABEL = "Remaining blocks:";

    @Override
    public String getLevel_name() {
        return "Level 2";
    }

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
                        //recorre la fila y si no tiene un fondo lo cambia a amarillo y guarda la cantidad de cambios
                    }
                }
            }
            // si no es horizontal el movimiento
            else {
                for (int k = 0; k < SIZE; k++) {
                    if (super.g()[k][j1].getBackground()==null){
                        super.g()[k][j1].setBackground(Color.YELLOW);
                        removeAmount++;
                        //recorre la fila y si no tiene un fondo lo cambia a amarillo y guarda la cantidad de cambios
                    }
                }
            }
        }
        state.decreaseGoldenRemaining(removeAmount);
        //decrementa la cantidad de golden que quedan despues de la movida
        return aux;
    }
    // revisa si la movida fue horizontal o vertical
    private boolean horizontalMove(int i1, int i2) {
        return i1 - i2 == 0;
    }

    private static class Level2State extends GameState {
        private long maxMoves;

        Level2State(int maxMoves) {
            this.maxMoves = maxMoves;
            this.secondScore = INITIAL_VALUE;
            this.hasSecondScore = true;
            this.secondLabel = SECOND_LABEL;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }
    // se fija que la cantidad de golden remaining sea 0.
        public boolean playerWon() {
            return secondScore == 0;
        }

        // Retorna el el segundo score
        public String getSecondScore() { return ((Long)secondScore).toString(); }

        void decreaseGoldenRemaining(int amount){
            secondScore -= amount;
        }
    }
}
