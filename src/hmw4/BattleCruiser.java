package hmw4;

import java.util.Arrays;

public class BattleCruiser  extends Ship {
    
    public BattleCruiser () {
	this.setLength(7);
	this.setHit(new boolean[7]);
	Arrays.fill(this.getHit(), false);
	
    }

    /*
     * Returns one of the strings
     */
    @Override
    public String getShipType() {
	return "battlecruiser";
    }

}

