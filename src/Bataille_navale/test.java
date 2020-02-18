package Bataille_navale;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) throws ExceptionShipPosition {
		Destroyer d = new Destroyer();
		Submarine s1 = new Submarine();
		Submarine s2 = new Submarine();
		BattleShip p = new BattleShip();
		AirCraftCarrier a = new AirCraftCarrier();		
		
		Board  b1 =new Board("B1",10);
		Board  b2 =new Board("B2",10);
		
		List<AbstractShip> ships = new ArrayList<AbstractShip>();
		ships.add(d);
		ships.add(s1);
		ships.add(s2);
		ships.add(a);
		ships.add(p);
		
		//d.setOrientation(Orientation.NORTH);
		//b1.putShip(d, 4, 4);
		
		 //b1.print();
		Player player = new Player(b1,b2, ships);
		player.putShips();
	}

}


