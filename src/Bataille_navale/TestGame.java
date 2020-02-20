package Bataille_navale;

import java.io.Console;
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
		ships.add(s1);
		ships.add(s2);
		ships.add(bs);
		ships.add(c);
		
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
	    	   GameTwoPlayers gameTwo = new GameTwoPlayers();
	    	   gameTwo.init(size, ships, ships1);
	    	   gameTwo.run();
	    	   break;
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
		
		
		
		
		
		
		
		
		
		
		/**************Simple Player*********************/
		/*
		Player p1 = new Player(b1,b2,ships);
		Player p2 = new Player(b2,b1,ships1);

		b1=p1.board;
		b2=p2.board;
		p1.putShips();
		p1.board.print(p1.opponentBoard.getGrille_frappe());
		
		p2.putShips();
		p2.board.print(p2.opponentBoard.getGrille_frappe());
		
		while (true) {
			
			hit=p1.sendHit(coords);
			p1.board.print(p1.opponentBoard.getGrille_frappe());
			System.out.println(hit);
		
			
			hit1=p2.sendHit(coords1);
			p2.board.print(p2.opponentBoard.getGrille_frappe());
			System.out.println(hit1);
			
			
		}
		*/
		/*************************************************/
		
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
			//sleep(20);
				
		}
		b1.print(b1.grille_frappe);
		*/
		/***************************************************************/
		
		
		/********Human Player VS Artificial Intelligence Player********/
		/*
		Game game = new Game();
		game.init(size, ships,ships1);
		game.run();
		*/
		/*************************************************************/

		/********************Two players mode*************************/
		/*
		GameTwoPlayers game = new GameTwoPlayers();
		game.init(size, ships, ships1);
		game.run();
		*/
		/************************************************************/
		
		
		
		
		
		
		
		
		
}

	
    

	private static void sleep(int ms) {	
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}

