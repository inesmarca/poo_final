package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.TimedCandy;

import java.util.List;

public class MultiTypeCandyGeneratorCell extends CandyGeneratorCell {
    private int BOMB_CHANCE=93;
    private int fuse;

    public MultiTypeCandyGeneratorCell(Grid grid, int fuse) {
        super(grid);
        this.fuse=fuse;

    }
    @Override
    public Element getContent() {
        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random()*100);

        if (j>BOMB_CHANCE){

            return new TimedCandy(CandyColor.values()[i],fuse);
        }

        return new Candy(CandyColor.values()[i]);

    }
}
