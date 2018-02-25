package hmw2;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest {
    Squarelotron squarelotron3;
    Squarelotron squarelotron4;
    Squarelotron squarelotron7;

    @BeforeEach
    void setUp() throws Exception {
	squarelotron3 = new Squarelotron(3);
	squarelotron4 = new Squarelotron(4);
	squarelotron7 = new Squarelotron(7);

    }

    @Test
    void testSquarelotron() {
	assertTrue(squarelotron4.squarelotron[1][1] == 6);
	assertTrue(squarelotron4.squarelotron[2][3] == 12);
	assertTrue(squarelotron7.squarelotron[3][4] == 26);
	assertTrue(squarelotron7.squarelotron[6][1] == 44);
    }

    @Test
    void testFindMaxRings() {
	assertTrue(squarelotron4.findMaxRings() == 2);
	assertTrue(squarelotron7.findMaxRings() == 4);
    }

    @Test
    void testUpsideDownFlip() {
	assertTrue(squarelotron4.upsideDownFlip(1).squarelotron[1][1] == 6);
	assertTrue(squarelotron4.upsideDownFlip(1).squarelotron[2][3] == 8);
	assertTrue(squarelotron4.upsideDownFlip(2).squarelotron[1][1] == 10);
	assertTrue(squarelotron4.upsideDownFlip(2).squarelotron[2][3] == 12);
	assertTrue(squarelotron7.upsideDownFlip(0).squarelotron[6][6] == 49);
	int[] arrayTest = { 1, 2, 3, 4 };
	assertArrayEquals(arrayTest, squarelotron4.upsideDownFlip(1).squarelotron[3]);
	int[] arrayTest2 = { 9, 6, 7, 12 };
	assertArrayEquals(arrayTest2, squarelotron4.upsideDownFlip(2).squarelotron[2]);
    }

    @Test
    void testMainDiagonalFlip() {
	assertTrue(squarelotron4.mainDiagonalFlip(1).squarelotron[1][1] == 6);
	assertTrue(squarelotron4.mainDiagonalFlip(1).squarelotron[2][3] == 15);
	assertTrue(squarelotron4.mainDiagonalFlip(2).squarelotron[1][1] == 6);
	assertTrue(squarelotron4.mainDiagonalFlip(2).squarelotron[2][1] == 7);
	assertTrue(squarelotron4.mainDiagonalFlip(2).squarelotron[3][2] == 15);
	assertTrue(squarelotron7.mainDiagonalFlip(3).squarelotron[1][1] == 9);
	assertTrue(squarelotron7.mainDiagonalFlip(3).squarelotron[6][1] == 44);
	assertTrue(squarelotron7.mainDiagonalFlip(3).squarelotron[3][4] == 32);
    }

    @Test
    void testRotateRight() {
	squarelotron4.rotateRight(0);
	assertTrue(squarelotron4.squarelotron[1][1] == 6);
	squarelotron4.rotateRight(1);
	assertTrue(squarelotron4.squarelotron[1][1] == 10);
	assertTrue(squarelotron4.squarelotron[3][3] == 4);
	squarelotron4.rotateRight(-2);
	assertTrue(squarelotron4.squarelotron[1][1] == 7);
	assertTrue(squarelotron4.squarelotron[3][3] == 13);
	squarelotron7.rotateRight(3);
	int[] arrayTest = { 7, 14, 21, 28, 35, 42, 49 };
	assertArrayEquals(arrayTest, squarelotron7.squarelotron[0]);
	int[] arrayTest1 = { 7, 14, 21, 28, 35, 42, 49 };
	assertArrayEquals(arrayTest, squarelotron7.squarelotron[0]);

    }

    @Test
    void testMain() {
	fail("Not yet implemented");
    }

}
