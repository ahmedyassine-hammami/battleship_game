package Bataille_navale;

public class Submarine extends AbstractShip {

	public Submarine(Orientation o) {
		// TODO Auto-generated constructor stub
			super("Submarine",'S',3,o);		
	}
	public Submarine() {
		super("Submarine",'S',3,Orientation.EAST);
	}

}
