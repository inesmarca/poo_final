package game.backend.element;

import game.backend.move.Direction;

public abstract class Element {


	public abstract boolean isMovable();
	
	public abstract String getKey();
	
	public String getFullKey() {
		return getKey();
	}

	public boolean isSolid() {
		return true;
	}
	
	public Direction[] explode() {
		return null;
	}
	
	public long getScore() {
		return 0;
	}

	// devuelve un string para tener como texto en un overlay,
	// por default esta en null pero cualquier clase que extinda Element lo puede sobreescribir

	public String DisplayText(){return null;}
	
}
