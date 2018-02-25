package hmw4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testGetShipType() {
	Ship myShip = new BattleCruiser();
	assertEquals(7, myShip.getLength());
	assertEquals("battlecruiser", myShip.getShipType());
    }

    @Test
    void testGetShipType2() {
	Ship myShip = new Destroyer();
	assertEquals(4, myShip.getLength());
	assertEquals("destroyer", myShip.getShipType());
    }

    @Test
    void testOkToPlaceShipAt() {
	Ship myShip = new Destroyer();
	Ship myShip2 = new LightCruiser();
	Ocean myOcean = new Ocean();
	assertFalse(myShip.okToPlaceShipAt(18, 18, true, myOcean));
	assertFalse(myShip.okToPlaceShipAt(18, 18, false, myOcean));
	assertTrue(myShip2.okToPlaceShipAt(5, 5, true, myOcean));
    }
    /*
    @Test
    void testPlaceShipAt() {
	fail("Not yet implemented");
    }*/

    @Test
    void testShootAt() {
	Ship myShip = new Destroyer();
	Ship myShip2 = new LightCruiser();
	Ocean myOcean = new Ocean();
	myShip.placeShipAt(10, 10, true, myOcean);
	assertTrue(myShip.shootAt(10, 10));
    }

    @Test
    void testIsSunk() {
	Ocean myOcean = new Ocean();
	Ship myShip = new BattleShip();
	Ship myShip2 = new Cruiser();
	myShip.placeShipAt(0, 10, true, myOcean);
	for (int j = 10; j < 18; j++) {
	    myOcean.shootAt(0, j);
	}
	assertTrue(myShip.isSunk());
	myShip2.placeShipAt(0, 0, false, myOcean);
	for (int i = 0; i < 3; i++) {
	    myOcean.shootAt(i, 0);
	}
	assertFalse(myShip2.isSunk());
    }

    @Test
    void testToString() {
	Ocean myOcean = new Ocean();
	Ship myShip = new BattleShip();
	Ship myShip2 = new Submarine();
	myShip.placeShipAt(0, 0, true, myOcean);
	for (int j = 0; j < 8; j++) {
		myOcean.shootAt(0, j);
	}
	assertEquals("x", myShip.toString());
	
	myShip2.placeShipAt(2, 0, false, myOcean);
	myOcean.shootAt(2, 0);
	assertEquals("S", myShip2.toString());
    }
    /*
    @Test
    void testGetBowRow() {
	fail("Not yet implemented");
    }

    @Test
    void testSetBowRow() {
	fail("Not yet implemented");
    }

    @Test
    void testGetBowCol() {
	fail("Not yet implemented");
    }

    @Test
    void testSetBowCol() {
	fail("Not yet implemented");
    }

    @Test
    void testGetLength() {
	fail("Not yet implemented");
    }

    @Test
    void testSetLength() {
	fail("Not yet implemented");
    }

    @Test
    void testIsHorizontal() {
	fail("Not yet implemented");
    }

    @Test
    void testSetHorizontal() {
	fail("Not yet implemented");
    }

    @Test
    void testGetHit() {
	fail("Not yet implemented");
    }

    @Test
    void testSetHit() {
	fail("Not yet implemented");
    }*/

}
