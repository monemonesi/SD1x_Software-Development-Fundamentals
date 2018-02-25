package hmw4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testOcean() {
	//fail("Not yet implemented");
    }

    @Test
    void testPlaceAllShipsRandomly() {
	Ocean myOcean = new Ocean();
	myOcean.placeAllShipsRandomly();
	assertEquals(0, myOcean.getHitCount());
	assertEquals(0, myOcean.getShipsSunk());
	assertEquals(0, myOcean.getShotsFired());
	//check the total number of square filled by ships:
	//it must be:
	//8 + 7 + 2*6 + 2*5 + 3*4 + 4*3 = 61
	int shipCount = 0;
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			if (!myOcean.getShipArray()[i][j].getShipType().equals("empty")) {
				shipCount++;
			}
			
		}
	}
	assertEquals(61, shipCount);
	
    }

    @Test
    void testIsOccupied() {
	Ocean myOcean = new Ocean();
	Ship myShip = new BattleShip();
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			assertFalse( myOcean.isOccupied(i, j));
		}
	}
	myShip.placeShipAt(0, 0, true, myOcean);
	assertFalse(myOcean.isOccupied(1,10));
	assertTrue(myOcean.isOccupied(0,3));
    }

    @Test
    void testShootAt() {
	Ocean myOcean = new Ocean();
	BattleShip ship = new BattleShip();
	ship.placeShipAt(0, 0, true, myOcean);
	myOcean.shootAt(0, 0);
	myOcean.shootAt(0, 0);
	myOcean.shootAt(1, 0);
	assertEquals(2, myOcean.getHitCount());
	assertEquals(0, myOcean.getShipsSunk());
	assertEquals(3, myOcean.getShotsFired());
    }
    /*
    @Test
    void testGetShotsFired() {
	fail("Not yet implemented");
    }

    @Test
    void testGetHitCount() {
	fail("Not yet implemented");
    }

    @Test
    void testGetShipsSunk() {
	fail("Not yet implemented");
    }

    @Test
    void testIsGameOver() {
	fail("Not yet implemented");
    }

    @Test
    void testGetShipArray() {
	fail("Not yet implemented");
    }

    @Test
    void testPrint() {
	fail("Not yet implemented");
    }*/

}
