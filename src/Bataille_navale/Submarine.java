package Bataille_navale;

public class Submarine extends AbstractShip {

	public Submarine(Orientation o) {
	
			super("Submarine",'S',3,o);		
	}
	public Submarine() {
		super("Submarine",'S',3,Orientation.EAST);
	}
	@Override
	public void setOrientation(Orientation orientation) {
		// TODO Auto-generated method stub
		this.orientation = orientation;
	}

	
}
