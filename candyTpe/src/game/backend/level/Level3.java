package game.backend.level;

import game.backend.GameState;
import game.backend.cell.MultiTypeCandyGeneratorCell;
import game.backend.element.TimedCandy;

public class Level3 extends Levels {
    private static int BOMB_FUSE=10;
    private static int REQUIRED_SCORE = 5000;
    private static int MAX_MOVES = 20;


    @Override
    public String getLevel_name() {
        return "Level 3";
    }

    @Override
    protected GameState newState() {
        return new Level3.Level3State(REQUIRED_SCORE, MAX_MOVES);
    }

    @Override
    // se sobreescribe este metodo para poder usar un generador de candy que incluya otros tipos de candy(Timed candy en este caso)
    protected void CreateCandyGenCell() {
        this.candyGenCell= new MultiTypeCandyGeneratorCell(this, BOMB_FUSE);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean aux = super.tryMove(i1, j1, i2, j2);

        // En esta parte solo decrementa el valor de las bombas
        if (aux) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (g()[i][j].getContent().getKey().equals(new TimedCandy().getKey())) {
                        TimedCandy timedCandy = (TimedCandy) g()[i][j].getContent();
                        timedCandy.decreaseTimer();
                    }
                }
            }
        }

        return aux;
    }

    // Esta funcion esta hecha para encontrar cual es la bomba con menor valor
    public Integer getShortestFuse() {
        int shortest_fuse = BOMB_FUSE + 1;
        boolean bomb_present = false;

        for (int i = 0; i <SIZE ; i++) {
            for (int j = 0; j <SIZE ; j++) {
                if (g()[i][j].getContent().getKey().equals(new TimedCandy().getKey())){
                    bomb_present = true;
                    TimedCandy timedCandy =(TimedCandy) g()[i][j].getContent();
                    if (shortest_fuse>timedCandy.getTimer()){
                        shortest_fuse=timedCandy.getTimer();
                    }
                }

            }
        }
        if (!bomb_present) {
            return null;
        }
        return shortest_fuse;
    }

    private class Level3State extends GameState {
        private long requiredScore;
        private long maxMoves;

        private Level3State(long requiredScore, int maxMoves) {
            this.requiredScore = requiredScore;
            this.maxMoves = maxMoves;
        }

        boolean bombExploded() {
            Integer value = getShortestFuse();
            return value != null && value == 0;
        }

        @Override
        public boolean gameOver() {
            return bombExploded() || getMoves() >= maxMoves;
        }

        @Override
        public boolean playerWon() {
            return getScore() > requiredScore;
        }

        // Retorna el el segundo score
        public String getSecondScore() {
            if (getShortestFuse() == null) {
                return "No bombs";
            }
            return getShortestFuse().toString();
        }

    }
}
