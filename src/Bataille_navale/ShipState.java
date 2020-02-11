package Bataille_navale;

public class ShipState {
	public AbstractShip ship ;
	private boolean struck ;
	
	
	public void addStrike() {
		if(ship.strikeCount<ship.taille) {
			this.struck=true;
			ship.addStrike();	
		}
	}
	
	 public boolean isStruck() {
		 return struck;
	 }
	 
	 public String toString() {
		 return (ColorUtil.colorize(ship.label, ColorUtil.Color.RED));
	 }
	 
	 public boolean isSunk() {
		 if(ship.strikeCount==ship.taille) return true ;
		 return false;
	 }
	 
	 public AbstractShip getShip() {
		 return this.ship;
	 }
	 

}
