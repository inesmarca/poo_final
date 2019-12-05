package game.backend.level;

import game.backend.GameState;
import game.backend.cell.MultiTypeCandyGeneratorCell;
import game.backend.element.Candy;
import game.backend.element.TimedCandy;
import javafx.scene.paint.Color;

import java.util.Map;

public class Level3 extends Levels {
    private static int BOMB_FUSE=10;
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
        private int shortest_fuse;
        private boolean bombs_present;

        private Level3State(long requiredScore, int maxMoves) {
            this.requiredScore = requiredScore;
            this.maxMoves = maxMoves;
            this.bomb_exploded=false;

        }
        private void Exploded(){
            bomb_exploded=true;
        }
        public int getShortest_fuse(){
            return shortest_fuse;
        }


        @Override
        public boolean gameOver() {
            return !bomb_exploded && (playerWon() || getMoves() >= maxMoves);
        }

        @Override
        public boolean playerWon() {
            return getScore() > requiredScore;
        }

        // Retorna el el segundo score
        public long getSecondScore() { return shortest_fuse; }
    }
    @Override
    // se sobreescribe este metodo para poder usar un generador de candy que incluya otros tipos de candy(Timed candy en este caso)
    protected void CreateCandyGenCell() {
        this.candyGenCell= new MultiTypeCandyGeneratorCell(this,BOMB_FUSE);
    }
    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean aux = super.tryMove(i1, j1, i2, j2);

         // recorre el tablero entero y busca la bomba con el fusible mas corto;
        // si la encuentra guarda la cantidad restante de turnos en la variable shortest_fuse
        // si no la encuentra, cambia la variable bombs_present.
        // si encunetra una bomba explotada, llama a la funcion explode que establece la condicion de perder la partida.

        int shortest_fuse=BOMB_FUSE+1;
        Level3State state=(Level3State) state();
        for (int i = 0; i <SIZE ; i++) {
            for (int j = 0; j <SIZE ; j++) {
                if (g()[i][j].getContent().getKey().equals(new TimedCandy().getKey())){
                    TimedCandy timedCandy =(TimedCandy) g()[i][j].getContent();
                    timedCandy.decreaseTimer();
                    if (shortest_fuse>timedCandy.getTimer()){
                        shortest_fuse=timedCandy.getTimer();
                        state.bombs_present=true;
                    }
                }

            }
        }

        if (shortest_fuse<=0){ state.Exploded(); }
        if (shortest_fuse==BOMB_FUSE+1){
            state.bombs_present=false;
        }
        state.shortest_fuse=shortest_fuse;


        return aux;
    }
}
