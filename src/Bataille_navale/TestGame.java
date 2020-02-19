package Bataille_navale;

import java.util.ArrayList;
import java.util.List;

public class TestGame {

	public static void main(String[] args) throws Exception {
		int size = 10 ;
		int destroyedShips = 0;
		Destroyer d = new Destroyer();
		Submarine s1 = new Submarine();
		Submarine s2 = new Submarine();
		BattleShip b = new BattleShip();
		AirCraftCarrier c = new AirCraftCarrier();		
		
		Board  b1 =new Board("B1",size);
		
		List<AbstractShip> ships = new ArrayList<AbstractShip>();
		ships.add(d);
		ships.add(s1);
		ships.add(s2);
		ships.add(b);
		ships.add(c);
		
		Hit hit;
		char[] label = new char[size];
		
		for (int l=0;l<size;l++)
			label[l]=(char)(65+l);
	
		BattleShipsAI battleAI= new  BattleShipsAI(b1, b1);
		int[] coord = new int[2] ;
		battleAI.putShips(ships);
		

		int i = 1;
		while(destroyedShips<ships.size())
		{
			hit=battleAI.sendHit(coord);
			if(hit.toString().compareTo("touché")==0 || hit.toString().compareTo("manqué")==0) 
				System.out.println("Hit N°"+i+" state : "+hit.toString()+" in "+label[coord[1]]+""+(coord[0]+1));
			else {
				System.out.println("Hit N°"+i+" "+hit.toString()+" is completely destroyed!");
				destroyedShips++;
			}
			i++;
			sleep(120);
				
		}
		
		b1.print();
		
	
		 //b1.print();
		//Player player = new Player(b1,b2, ships);
		//player.putShips();
		//b2.putShip(d, 2, 1);
		
		//hit = b1.sendHit(1,1);
		//hit = b1.sendHit(1,1);
		//hit = b2.sendHit(1,1);
		
	
		//player.sendHit(coord);
		
		
		//System.out.println(b2.hasShip(coord[0], coord[1]));
		//System.out.println(hit);
		//System.out.println(b1.sendHit(2,1).toString()+" is completely destroyed");
		//b2.print();
	}


private static void sleep(int ms) {
try {
Thread.sleep(ms);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}

