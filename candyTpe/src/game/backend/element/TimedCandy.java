package game.backend.element;

public class TimedCandy extends Candy {

    private int time_left = 10;
//los constructores son necesarios porque en los enum y como en el image manager, utiliza este formato.
    public TimedCandy(){}
    public TimedCandy(CandyColor color){super(color);}
    public TimedCandy(CandyColor color, int Time) {
        super(color);
        this.time_left=Time;
    }

    public int getTimer() {
        return time_left;
    }
    public void decreaseTimer(){
        if (time_left>0) {time_left--;}
    }
    @Override
    public String getKey(){
        return "TimedCandy";
    }
    @Override
    public String getFullKey(){
        return getColor()+"-TimedCandy";
    }
//los metodos equal y hashcode no pueden ser soobre escritos porque el programa usa el equals para determinar si una figura es compatible o no.
// y para seguir las buenas practicas de java, un elemento que tiene el mismo equals no puede tener un hashcode diferente.

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TimedCandy)) return false;
//        if (!super.equals(o)) return false;
//        TimedCandy that = (TimedCandy) o;
//        return time_left == that.time_left;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), time_left);
//    }

    @Override
    public boolean DisplayableText(){
        return true;
    }
    @Override
    public String DisplayText(){
        return Integer.toString(time_left);
    }
}
