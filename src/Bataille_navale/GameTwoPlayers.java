package Bataille_navale;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameTwoPlayers {

	 List<AbstractShip> ships = new ArrayList<AbstractShip>();
	    private Player player1= new Player(null, null,ships);
	    private Player player2=new Player(null, null,ships);;
	    private Scanner sc = new Scanner(System.in);
	    private File SAVE_FILE1 = new File("save1.ser");
	    private File SAVE_FILE2 = new File("save2.ser");
	    private String str1;
	    private String str2;
	    private Writer w =new Writer();
	   //Constructors
	
	    public boolean updateScore(Player p) {
	    	
	            int destroyed = 0;
	            for (AbstractShip ship : p.getShips()) {
	                if (ship.isSunk()) {
	                    destroyed++;
	                }
	            }

	            p.destroyedCount = destroyed;
	            p.lose = destroyed == p.getShips().length;
	            if (destroyed == p.getShips().length) {
	                return true;
	            }
	        
	        return false;
	    }

	    public void init(int size,List<AbstractShip> ships,List<AbstractShip> ships1) throws ClassNotFoundException, IOException, ExceptionShipPosition {
	    	
		    
	   
	            // Initialize attributes
	            System.out.println("Entrer le nom du joueur 1 :");
	            str1 = sc.nextLine();
	            
	            System.out.println("Entrer le nom du joueur 2 :");
	            str2 = sc.nextLine();
	            
	            //Initialize boards
	            Board  b1 =new Board("B1",size);
	    		Board  b2 =new Board("B2",size);
	    		
	            //Initialize Player1
	    		
	    		Player p1 = new Player(b1, b2, ships);
	    		this.player1=p1;
	    		player1.board.playerName=str1;
	    		
	            //Initialize Player2;
	    		Player p2 = new Player(b2, b1, ships1);
	    		this.player2=p2;
	    		player2.board.playerName=str2;
	            // place player ships randomly
	    		this.putShipsRandomly(ships,player1.board);
	            this.putShipsRandomly(ships1,player2.board);
	            System.out.println("Ships are putted randomly in two boards");
	            //player1.board.print(player2.board.getGrille_frappe());
	            //player2.board.print(player1.board.getGrille_frappe());
	    }
	   
	    
	    
	    public void init1(int size,List<AbstractShip> ships,List<AbstractShip> ships1) throws ClassNotFoundException, IOException, ExceptionShipPosition {
	    	Board a = w.load(SAVE_FILE1);
    		Board b= w.load(SAVE_FILE2);
   
	    	Board  b1 =new Board("B1",size);
	    	Board  b2 =new Board("B2",size);
	    	Player p1 = new Player(b1, b2, ships);
    		this.player1=p1;
    		Player p2 = new Player(b2, b1, ships1);
    		this.player2=p2;
    		str1=a.playerName;
    		str2=b.playerName;
    		this.player1.board=a;
    		this.player1.opponentBoard=b;
    		this.player2.board=b;
    		this.player2.opponentBoard=a;
	    }
	    	
	    	
	   public void run() throws Exception {
        int[] coords = new int[2];

        Hit hit;

        // main loop
        boolean done=false;
        boolean strike;
        do {
        	
            hit = Hit.MISS; 
            System.out.print("Joueur 1 : " +str1+", ");
            hit = player1.sendHit(coords);
            strike = hit != Hit.MISS;
  
            System.out.println(makeHitMessage(coords, hit));
     
            //player1.board.print(player2.board.getGrille_frappe());
            
            this.printHits(player1,this.str1);
            done=updateScore(player2);


            if (!done && !strike) {
                do {
                    hit = Hit.MISS; 
                    System.out.print("Joueur 2 : " +str2+", ");
                    hit = player2.sendHit(coords);
                    strike = hit != Hit.MISS;
                    
                
                    if (strike) {
                        player1.board.print(player2.board.grille_frappe);
                    }
                    
                    System.out.println(makeHitMessage(coords, hit));
                    
                    //player2.board.print(board1.getGrille_frappe());
                    
                    this.printHits(player2,this.str2);
                    done=updateScore(player1);
                
                    if (!done) {
                    	w.save(SAVE_FILE1, this.player1.board);
                    	w.save(SAVE_FILE2, this.player2.board);
                    }
                } while (strike && !done);
            }

        } while (!done);

        SAVE_FILE1.delete();
        SAVE_FILE2.delete();
        System.out.println(String.format("Joueur %d gagne", player1.lose ? 2 : 1));
        sc.close();
    }

    private void save() throws IOException {
    }

    
    

    private String makeHitMessage(int[] coords, Hit hit) {
        String msg;
        ColorUtil.Color color = ColorUtil.Color.RESET;
        switch (hit) {
        case MISS:
            msg = hit.toString();
            break;
        case STIKE:
            msg = hit.toString();
            color = ColorUtil.Color.RED;
            break;
        default:
            msg = hit.toString() + " coulé";
            color = ColorUtil.Color.RED;
        }
        msg = String.format("=> Frappe en %c%d : %s", ((char) ('A' + coords[1])-1),
                (coords[0]), msg);
        return ColorUtil.colorize(msg, color);
    }
    
    
    public void putShipsRandomly(List<AbstractShip> ships,Board board) throws ExceptionShipPosition {
        int x, y;
        int k = 0;
        Orientation o;
        Orientation[] orientations = Orientation.values();
        Random rand = new Random(); 
        boolean done = false;
        int i = 0 ;

        do {
            AbstractShip s = ships.get(i);
            boolean SafeRandom=false;
            try {
                k = rand.nextInt(4); 
                x = rand.nextInt(board.getSize())+1; 
                y = rand.nextInt(board.getSize())+1; 
                o=orientations[k];
                s.setOrientation(o);
                board.putShip(s, y, x);
            	   SafeRandom = true ;
            }
            
            
            catch (ExceptionShipPosition ex) {
            		SafeRandom = false ;
            }
            
            //When ship placement is successful
            if(SafeRandom) {
            		i++;
              	done = (i==ships.size());
            }
   
        } while (!done);
     }
    
    public void printHits(Player player1,String str) {
    	System.out.println();
		Boolean True = new Boolean(true);
		System.out.println("Hits of palyer "+str);
		System.out.println();
		System.out.print("    ");
		for (int l =0;l<player1.board.getSize();l++) {
			char c =(char)(65+l);
			System.out.print(" "+c+" ");
		}
		System.out.println();
		
		for(int i=0;i<player1.board.getSize();i++) {
			if (i<player1.board.getSize()-1) System.out.print((i+1)+" | ");
			else System.out.print((i+1)+"| ");
			for(int j=0;j<player1.board.getSize();j++) {
				
				if(player1.board.getGrille_frappe()[i][j]==null) System.out.print(" . ");
				else {
					if(player1.board.getGrille_frappe()[i][j].booleanValue()==true) System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.RED));
					else System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.WHITE));
				}
	
			}
			System.out.println();
		}
		System.out.println();
    }
    
    
    
}
