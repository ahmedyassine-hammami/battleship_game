package Bataille_navale;

import java.io.Serializable;

public class ShipState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AbstractShip ship ;
	public boolean struck = false;


	public void addStrike() {
		if(ship.strikeCount<ship.taille && struck==false) {
			this.struck=true;
			ship.strikeCount++;
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
