package Bataille_navale;

public class AirCraftCarrier extends AbstractShip {

	public AirCraftCarrier(Orientation o) {

		super("AirCraft-Carrier",'C',5,o);
	}
	public AirCraftCarrier() {
		super("AirCraft-Carrier",'C',5,Orientation.EAST);
	}
	@Override
	public void setOrientation(Orientation orientation) {
		// TODO Auto-generated method stub
		this.orientation = orientation;
		
	}
	

}
