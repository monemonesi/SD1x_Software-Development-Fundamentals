package hmw4;

import java.util.Random;

public class Ocean {

    /*
     * Creates an ”empty” ocean (fills the ships array with a bunch of EmptySea
     * instances). Also initialises any game variables, such as how many shots have
     * been fired.
     */
    private Ship[][] ships = new Ship[20][20];// Used to quickly determine which ship is in any given location.
    private int hitCount; // The number of times a shot hit a ship.
    private int shotsFired; // The total number of shots fired by the user.
    private int shipsSunk; // The number of ships sunk. Remember that you have a total of 13 ships.

    public Ocean() {
	shotsFired = 0;
	hitCount = 0;
	shipsSunk = 0;
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 20; j++) {
		EmptySea eSea = new EmptySea();
		eSea.placeShipAt(i, j, true, this);
	    }
	}
    }

    /*
     * Place all randomly on the (initially empty) ocean. Place larger ships before
     * smaller ones, or you may end up with no legal place to put a large ship. You
     * will want to use the Random class in the java.util package, so look that up
     * in the Java API.
     */
    public void placeAllShipsRandomly() {
	Random random = new Random();
	Ship[] ships = new Ship[13];
	for (int i = 0; i < 13; i++) {
	    if (i == 0) {
		ships[i] = new BattleShip();
	    } else if (i == 1) {
		ships[i] = new BattleCruiser();
	    } else if (i < 4) {
		ships[i] = new Cruiser();
	    } else if (i < 6) {
		ships[i] = new LightCruiser();
	    } else if (i < 9) {
		ships[i] = new Destroyer();
	    } else if (i < 13) {
		ships[i] = new Submarine();
	    }
	}

	for (Ship ship : ships) {
	    boolean shipPlaced = false;
	    while (!shipPlaced) {
		int row = random.nextInt(20);
		int column = random.nextInt(20);
		boolean isHoriz = random.nextBoolean();
		if (ship.okToPlaceShipAt(row, column, isHoriz, this)) {
		    ship.placeShipAt(row, column, isHoriz, this);
		    shipPlaced = true;
		}
	    }
	}
    }

    /*
     * Returns true if the given location contains a ship, false if it does not.
     */
    public boolean isOccupied(int row, int column) {
	return !ships[row][column].getShipType().equals("empty");
    }

    /*
     * Returns true if the given location contains a ”real” ship, still afloat, (not
     * an EmptySea), false if it does not. In addition, this method updates the
     * number of shots that have been fired, and the number of hits. Note: If a
     * location contains a ”real” ship, shootAt should return true every time the
     * user shoots at that same location. Once a ship has been ”sunk”, additional
     * shots at its location should return false.
     */
    public boolean shootAt(int row, int column) {
	this.shotsFired++;
	if (isOccupied(row, column)) {
	    if (ships[row][column].shootAt(row, column)) {
		if (ships[row][column].isSunk()) {
		    System.out.println("You just sunk a " + ships[row][column].getShipType());
		    shipsSunk++;
		}
		hitCount++;
		return true;
	    }
	    return false;
	} else {
	    ships[row][column].shootAt(row, column);
	}
	return false;
    }

    /*
     * Returns the number of shots fired (in this game).
     */
    public int getShotsFired() {
	return shotsFired;
    }

    /*
     * Returns the number of hits recorded (in this game). All hits are counted, not
     * just the first time a given square is hit.
     * 
     */
    public int getHitCount() {
	return hitCount;
    }

    /*
     * Returns the number of ships sunk (in this game).
     */
    public int getShipsSunk() {
	return shipsSunk;
    }

    /*
     * Returns true if all ships have been sunk, otherwise false.
     * 
     */
    public boolean isGameOver() {
	return shipsSunk == 13;
    }

    /*
     * Returns the 20x20 array of ships. The methods in the Ship class that take an
     * Ocean parameter really need to be able to look at the contents of this array;
     * the placeShipAt method even needs to modify it. While it is undesirable to
     * allow methods in one class to directly access instance variables in another
     * class, sometimes there is just no good alternative.
     */
    public Ship[][] getShipArray() {

	return ships;
    }

    /*
     * Prints the ocean. To aid the user, row numbers should be displayed along the
     * left edge of the array, and column numbers should be displayed along the top.
     * Numbers should be 00 to 19, not 1 to 20.
     * 
     * The top left corner square should be 0, 0. Use ’S’ to indicate a location
     * that you have fired upon and hit a (real) ship, ’-’ to indicate a location
     * that you have fired upon and found nothing there, ’x’ to indicate a location
     * containing a sunken ship, and ’.’ (a period) to indicate a location that you
     * have never fired upon.
     * 
     * This is the only method in the Ocean class that does any input/output, and it
     * is never called from within the Ocean class (except possibly during
     * debugging), only from the BattleshipGame class.
     */

    public void print() {
	StringBuilder sb = new StringBuilder();
	// create the first line with cell indications
	sb.append(" ");
	for (int i = 0; i < 20; i++) {
	    sb.append(String.format("%3d", i));
	}
	sb.append("\n");
	for (int i = 0; i < 20; i++) {
	    sb.append(String.format("%2d ", i));
	    for (int j = 0; j < 20; j++) {
		sb.append(ships[i][j]);
		sb.append("  ");
	    }

	    sb.append("\n");
	}
	System.out.println(sb.toString());

    }

}
