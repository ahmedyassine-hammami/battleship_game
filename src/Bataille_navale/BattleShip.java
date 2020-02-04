package Bataille_navale;

public class BattleShip extends AbstractShip {

	public BattleShip(Orientation o) {
		// TODO Auto-generated constructor stub
		super("BattleShip",'B',4,o);
		
	}
	public BattleShip() {
		super("BattleShip",'B',4,Orientation.EAST);
	}

}
