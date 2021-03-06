package Bataille_navale;

import java.io.Serializable;
import java.util.List;

public class AIPlayer extends Player implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
     * ** Attribut
     */
    private BattleShipsAI ai;
    private List<AbstractShip> Ships;

    
     //Constructeur
    
    	public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
        Ships=ships;
    	}
    	
    	public void putShips() {
    		   try {
				ai.putShips(this.Ships);
			} catch (ExceptionShipPosition e) {
			}
    	   }
    	
    	public Hit sendHit(int[] coords) throws Exception {
    		return ai.sendHit(coords);
    	}
    	
}
