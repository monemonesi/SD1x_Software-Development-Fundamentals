package hmw4;

import java.util.Arrays;

public class BattleShip extends Ship {
    
    public BattleShip() {
	this.setLength(8);
	this.setHit(new boolean[8]);
	Arrays.fill(this.getHit(), false);
	
    }

    /*
     * Returns one of the strings
     */
    @Override
    public String getShipType() {
	return "battleship";
    }

}
