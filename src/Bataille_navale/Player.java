package Bataille_navale;


import java.util.List;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }


    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            boolean Safeinput=false;
            try {
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
     
            String o = new String(res.orientation);
            if(o.equals("n"))
            	s.setOrientation(Orientation.NORTH);
            if (o.equals("s"))
            	s.setOrientation(Orientation.SOUTH);
            if (o.equals("e"))
            	s.setOrientation(Orientation.EAST);
            if(o.equals("w"))
            	s.setOrientation(Orientation.WEST);
            	board.putShip(s,res.y+1,res.x+1);
            	Safeinput = true ;
            }
            
            
            catch (ExceptionShipPosition ex) {
            	System.out.println(ex.getMessage());
            	Safeinput = false ;
            }
            
            //When ship placement is successful
            if(Safeinput) {
            	i++;
              	done = (i==5);
              	board.print();
            }
   
        } while (!done);
        
    }
    
    
    

    public Hit sendHit(int[] coords) {
        boolean done = true;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);
        
        return hit;
    }

    
    
    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}

