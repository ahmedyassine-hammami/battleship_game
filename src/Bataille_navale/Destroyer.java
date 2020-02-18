package Bataille_navale;


public class Destroyer extends AbstractShip {
	public Destroyer(Orientation o) {
	super("Destroyer",'D',2,o);
	}
	public Destroyer() {
		super("Destroyer",'D',2,Orientation.EAST);
	}
	@Override
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
		
	}
	

	
	

}
