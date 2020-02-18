package Bataille_navale;

public class BattleShip extends AbstractShip {

	public BattleShip(Orientation o) {
		
		super("BattleShip",'B',4,o);
		
	}
	public BattleShip() {
		super("BattleShip",'B',4,Orientation.EAST);
	}
	@Override
	public void setOrientation(Orientation orientation) {
		// TODO Auto-generated method stub
		this.orientation = orientation;
		
	}

}
