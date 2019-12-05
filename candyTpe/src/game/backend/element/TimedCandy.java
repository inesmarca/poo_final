package game.backend.element;

import java.util.Objects;

public class TimedCandy extends Candy {

    private int time_left;

    public TimedCandy(CandyColor color, int Time){
        super(color);
        this.time_left=Time;


    }

    public int getTimer() {
        return time_left;
    }
    public void decreaseTimer(){
        time_left--;
    }
    @Override
    public String getKey(){
        return "TimedCandy";
    }
    @Override
    public String getFullKey(){
        return getColor()+"-TimedCandy";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimedCandy)) return false;
        if (!super.equals(o)) return false;
        TimedCandy that = (TimedCandy) o;
        return time_left == that.time_left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time_left);
    }

    @Override
    public boolean DisplayableText(){
        return true;
    }
    @Override
    public String DisplayText(){
        return Integer.toString(time_left);
    }
}
