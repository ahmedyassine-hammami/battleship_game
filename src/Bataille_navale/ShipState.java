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
		 return "\033[31m"+ship.label;
	 }
	 
	 public boolean isSunk() {
		 if(ship.strikeCount==ship.taille) return true ;
		 return false;
	 }
	 
	 public AbstractShip getShip() {
		 return this.ship;
	 }
	 

}
