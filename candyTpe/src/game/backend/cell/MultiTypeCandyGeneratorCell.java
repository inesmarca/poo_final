package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.TimedCandy;

// es una clase generadora que genera no solo candy sino tambien TimedCandy

public class MultiTypeCandyGeneratorCell extends CandyGeneratorCell {
    private int BOMB_CHANCE = 6; //porcentaje de chance de que aparezca una bomba en vez de un caramelo normal
    private int fuse;

    public MultiTypeCandyGeneratorCell(Grid grid, int fuse) {
        super(grid);
        this.fuse=fuse;

    }
    @Override
    public Element getContent() {
        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random()*100);
        //elije si lo que se va a generar es una bomba o un caramelo
        if (j < BOMB_CHANCE) {

            return new TimedCandy(CandyColor.values()[i],fuse);
        }

        return new Candy(CandyColor.values()[i]);

    }
}
