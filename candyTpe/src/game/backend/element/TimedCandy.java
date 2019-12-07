package game.backend.element;

// es la clase que representa los candy que explotan en el nivel 3

public class TimedCandy extends Candy {
// la variable guarda la mecha
    private int time_left = 10;
//los constructores son necesarios porque en los enum y como en el image manager, utiliza este formato.
    public TimedCandy(){}
    public TimedCandy(CandyColor color){super(color);}
    public TimedCandy(CandyColor color, int Time) {
        super(color);
        this.time_left=Time;
    }
    //get del timer y un decrementador para moverlo cada turno
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

    // display text se sobreescribe y devuelve la cantidad de turnos restantes hasta que este candy explote
    @Override
    public String DisplayText(){
        return Integer.toString(time_left);
    }
}
