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
		Board  b2 =new Board("B2",size);
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
		int[] coords = new int[2] ;
	
		
		/**************BATTLE SHIP ARTIFICIAL INTELLIGENCE**************/
		/*
		BattleShipsAI battleAI= new  BattleShipsAI(b1, b1);
		AIPlayer player = new AIPlayer(b1,b1, ships);
		int[] coord = new int[2] ;

		//battleAI.putShips(ships);
		player.putShips();
		b1.print(b1.getGrille_frappe());
		
		int i = 1;
		while(destroyedShips<ships.size())
		{
			//hit=battleAI.sendHit(coord);
			hit=player.sendHit(coord);
			if(hit.toString().compareTo("touché")==0 || hit.toString().compareTo("manqué")==0) 
				System.out.println("Hit N°"+i+" state : "+hit.toString()+" in "+label[coord[1]]+""+(coord[0]+1));
			else {
				System.out.println("Hit N°"+i+" "+hit.toString()+" is completely destroyed!");
				destroyedShips++;
			}
			i++;
			sleep(20);
				
		}
		b1.print(b1.grille_frappe);
		*/
		/***************************************************************/
		
		
		/********Human Player VS Artificial Intelligence Player********/
		/*
		Game game = new Game();
		game.init(size, ships);
		game.run();
		*/
		/*************************************************************/

		boolean strike;
		boolean test=false;

		
		/*
Player p = new Player(b1,b2,ships);
Player p1 = new Player(b2,b1,ships);
p.putShips();
p1.putShips();
while(true) {
hit = p.sendHit(coords);
// TODO player1 send a hit
boolean strike = hit != Hit.MISS; 
b1.setHit(strike, coords[0], coords[1]);

b1.print();
*/
}

	


private static void sleep(int ms) {
try {
Thread.sleep(ms);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}

