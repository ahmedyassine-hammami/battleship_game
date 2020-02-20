package Bataille_navale;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;

public class Game {

    /*
     * *** Constant
     */
    public static final File SAVE_FILE = new File("savegame.dat");

    /*
     * *** Attributes
     */
    List<AbstractShip> ships = new ArrayList<AbstractShip>();
    public Player player1= new Player(null, null,ships);
    public Player player2 ;
   // private Scanner sin;

   //Constructors
    
    public Game() {
    }
    
    public boolean updateScore() {
        for (Player player : new Player[] { player1, player2 }) {
            int destroyed = 0;
            for (AbstractShip ship : player.getShips()) {
                if (ship.isSunk()) {
                    destroyed++;
                }
            }

            player.destroyedCount = destroyed;
            player.lose = destroyed == player.getShips().length;
            if (player.lose) {
                return true;
            }
        }
        return false;
    }

    public void init(int size,List<AbstractShip> ships) throws ClassNotFoundException, IOException {
        //if (!loadSave()) {
            // Initialize attributes
            System.out.println("Entrer votre nom:");

            // TODO use a scanner to read player name

            //Initialize boards
            Board  b1 =new Board("B1",size);
    		Board  b2 =new Board("B2",size);
    		
            //Initialize Player1
    		
    		Player p1 = new Player(b1, b2, ships);
    		this.player1=p1;
       
    		
            //Initialize Player2;
    		Player p = new AIPlayer(b2, b1, ships);
    		this.player2=p;
           
            
            // place player ships
            player1.putShips();
            player2.putShips();
            
            player1.board.print(b2.getGrille_frappe());
            //player2.board.print(b1.getGrille_frappe());
        
    
    }

    // Methods
  
    
    public void run() throws Exception {
        int[] coords = new int[2];
        Board board1 = player1.board;
        Board board2 = player2.board;
        Hit hit;

        // main loop
        boolean done=false;
        boolean strike;
        do {
            hit = Hit.MISS; 
            hit = player1.sendHit(coords);
            // TODO player1 send a hit
            strike = hit != Hit.MISS;
           
            done = updateScore();
            
            System.out.println(makeHitMessage(false /* outgoing hit */, coords, hit));

            //save();

            if (!done && !strike) {
                do {
                    hit = Hit.MISS; 
                    //player2 send a hit.
                    hit = player2.sendHit(coords);
                    
                    strike = hit != Hit.MISS;
                    coords[0]++;
                    coords[1]++;
                    if (strike) {
                        board1.print(board2.grille_frappe);
                    }
                    System.out.println(makeHitMessage(true /* incoming hit */, coords, hit));
                    done = updateScore();

                    if (!done) {
                        save();
                    }
                } while (strike && !done);
            }
            player1.board.print(board2.getGrille_frappe());
            //player2.board.print(board1.getGrille_frappe());
        } while (!done);

        //SAVE_FILE.delete();
        System.out.println(String.format("joueur %d gagne", player1.lose ? 1 : 2));
        //sin.close();
    }

    private void save() throws IOException {
    }

    
    

    private String makeHitMessage(boolean incoming, int[] coords, Hit hit) {
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
        msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords[1])-1),
                (coords[0]), msg);
        return ColorUtil.colorize(msg, color);
    }

    @SuppressWarnings("unused")
	private static List<AbstractShip> createDefaultShips() {
        return Arrays.asList(new AbstractShip[] { new Destroyer(), new Submarine(), new Submarine(), new BattleShip(),
                new AirCraftCarrier() });
    }
}
