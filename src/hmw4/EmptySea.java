package hmw4;

import java.util.Arrays;

public class EmptySea extends Ship {
    
    public EmptySea() {
	this.setLength(1);
	this.setHit(new boolean[1]);
	Arrays.fill(this.getHit(), false);
    }
    
    
    /*
     * (non-Javadoc)
     * @see hmw4.Ship#shootAt(int, int)
     * This method overrides shootAt(int row, int column) that is inherited from Ship,
     *  and always returns false to indicate that nothing was hit.
     */
    @Override
    public boolean shootAt(int row, int column) {
	this.getHit()[0] = true;
	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see hmw4.Ship#isSunk()
     * his method overrides isSunk() that is inherited from Ship, 
     * and always returns false to indicate that you didn’t sink anything.
     */
    @Override
    public boolean isSunk() {
	return false;
    }
    
    /*
     * (non-Javadoc)
     * @see hmw4.Ship#toString()
     * Returns a single-character String to use in the Ocean’s print method.
     */
    @Override
    public String toString() {
	return this.getHit()[0] == true ? "-" : ".";
    }
    
    @Override
    public String getShipType() {
	
	return "empty";
    }

}
