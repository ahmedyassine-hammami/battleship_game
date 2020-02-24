package Bataille_navale;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestGame {

	public static void main(String[] args) throws Exception {
		//Initialize size of the board
		int size = 10 ;
		//desroyedShips is used in Battleship AI
		int destroyedShips = 0;
		//Initialize ships
		Destroyer d = new Destroyer();
		Submarine s1 = new Submarine();
		Submarine s2 = new Submarine();
		BattleShip bs = new BattleShip();
		AirCraftCarrier c = new AirCraftCarrier();		
		
		Destroyer d1 = new Destroyer();
		Submarine s11 = new Submarine();
		Submarine s21 = new Submarine();
		BattleShip bs1 = new BattleShip();
		AirCraftCarrier c1 = new AirCraftCarrier();
	
		List<AbstractShip> ships = new ArrayList<AbstractShip>();
		List<AbstractShip> ships1 = new ArrayList<AbstractShip>();
		ships.add(d);
		//ships.add(s1);
		//ships.add(s2);
		//ships.add(bs);
		//ships.add(c);
		
		ships1.add(d1);
		ships1.add(s11);
		ships1.add(s21);
		ships1.add(bs1);
		ships1.add(c1);
	
		
		Board  b1 =new Board("B1",size);
		Board  b2 =new Board("B2",size);
		
		Hit hit;
		Hit hit1;
		
		char[] label = new char[size];
		
		for (int l=0;l<size;l++)
			label[l]=(char)(65+l);
		int[] coords = new int[2] ;
		int[] coords1 = new int[2] ;
		
	    System.out.println("--------------Battleship game-------------");
	    System.out.println("[1] : Player VS Computer");
	    System.out.println("[2] : Two players mode");
	    System.out.println("[3] : Battleship Artificial Intelligence");
	    System.out.println("------------------------------------------");
	    int l;
	    Scanner s = new Scanner(System.in);  
	    l = s.nextInt();
	      switch(l) {
	       case 1:
	    	   	Game game = new Game();
	    	   	
	   			game.init(size, ships,ships1);
	   			
	   			game.run();
	   			break;
	       case 2:
	    	System.out.println("---Continuer un jeu existant?---");
	    	System.out.println("[1] : Non");
	 	    System.out.println("[2] : Oui");
	   	    int l1;
	   	    Scanner s5 = new Scanner(System.in);  
	   	    l1 = s5.nextInt();
	   	    if(l1==1) {
	   	    	GameTwoPlayers gameTwo = new GameTwoPlayers();
		    	   gameTwo.init(size, ships, ships1);
		    	   gameTwo.run();
		    	   break;
	   	    }
	 	    if(l1==2) {
	   	    	   GameTwoPlayers gameTwo1 = new GameTwoPlayers();
		    	   gameTwo1.init1(size, ships, ships1);
		    	   gameTwo1.run();
		    	   break;
	   	    }
	       case 3:
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
	   				b1.print(b1.grille_frappe);
	   				destroyedShips++;
	   			}
	   			i++;
	   			sleep(2);
	   				
	   		}
	   
	    	   break;
	       default:
	    	   break;
	       
	     }		
}

	
    

	private static void sleep(int ms) {	
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}

