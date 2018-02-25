package hmw2;
import java.util.Arrays;

public class Squarelotron {

    // fields
    int size;
    int[][] squarelotron;

    // constructor
    public Squarelotron(int n) {
	this.size = n;
	squarelotron = new int[n][n];

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		squarelotron[i][j] = (i * n) + j + 1;
	    }
	}

    }

    // methods

    void displaySquarelotron() {
	for (int i = 0; i < size; i++) {
	    System.out.println(Arrays.toString(squarelotron[i]));
	}
    }

    int findMaxRings() {
	/*
	 * int r; if (this.size%2==0) { r = this.size/2; } else { r= (this.size/2)+1; }
	 * return r;
	 */
	// compact way to write it:
	return (this.size % 2 == 0) ? (size / 2) : (size / 2 + 1);
    }

    // call it like: originalSquarelotron.copySquareTo(s);
    void copySquareTo(Squarelotron s) {
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		s.squarelotron[i][j] = this.squarelotron[i][j];
	    }
	}
    }

    Squarelotron upsideDownFlip(int ring) {
	Squarelotron s = new Squarelotron(size);
	this.copySquareTo(s);

	if (ring < 1 || ring > this.findMaxRings()) {
	    System.out.println("");
	    return s;
	}

	// Squarelotron s = new Squarelotron(size);
	// this.copySquareTo(s);
	else {
	    // manipulate the new squarelotron
	    int startDomain = ring - 1;// translate from 2->1 etc....
	    int endDomain = size - ring;// translation for the end of the domain

	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    // work on the horizontal lines
		    if ((i == startDomain || i == endDomain) && (j >= startDomain && j <= endDomain)) {
			s.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
		    }
		    // Vertical lines
		    else if ((i > startDomain && i < endDomain) && (j == startDomain || j == endDomain)) {
			s.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
		    }
		}
	    }
	    return s;
	}

    }

    Squarelotron mainDiagonalFlip(int ring) {

	Squarelotron s = new Squarelotron(size);
	this.copySquareTo(s);
	if (ring < 1 || ring > this.findMaxRings()) {
	    System.out.println("");
	    return s;
	} else {
	    // manipulate the new squarelotron
	    int startDomain = ring - 1;// translate from 2->1 etc....
	    int endDomain = size - ring;// translation for the end of the domain

	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    // work on the horizontal lines
		    if ((i == startDomain || i == endDomain) && (j >= startDomain && j <= endDomain)) {
			s.squarelotron[i][j] = this.squarelotron[j][i];
		    }
		    // Vertical lines
		    else if ((i > startDomain && i < endDomain) && (j == startDomain || j == endDomain)) {
			s.squarelotron[i][j] = this.squarelotron[j][i];
		    }
		}
	    }

	    return s;
	}

    }

    //
    void rotateRightOnce() {
	for (int k = 0; k < size / 2; k++) {
	    int[] savedArray = new int[size - 2 * k];
	    int n = 0;
	    for (int j = k; j < size - k; j++) {
		savedArray[n] = squarelotron[k][j];
		n++;
	    }
	    for (int j = k; j < size - k; j++) {
		squarelotron[k][j] = squarelotron[size - 1 - j][k];
	    }
	    for (int i = k; i < size - k; i++) {
		squarelotron[i][k] = squarelotron[size - 1 - k][i];
	    }
	    for (int j = k; j < size - k; j++) {
		squarelotron[size - 1 - k][j] = squarelotron[size - 1 - j][size - 1 - k];
	    }
	    n = 0;
	    for (int i = k; i < size - k; i++) {
		squarelotron[i][size - 1 - k] = savedArray[n];
		n++;
	    }
	}
    }

    void rotateRight(int numberOfTurns) {

	int ring;
	boolean right = true;
	int maxRing = findMaxRings();

	// A Square to use as temp storage bewtween rotations
	int[][] tmpArr = new int[size][size];

	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		tmpArr[i][j] = this.squarelotron[i][j];
	    }
	}

	if (numberOfTurns < 0) {
	    right = false;
	    numberOfTurns *= -1;
	}

	// Go through rings, to rotate entire Square
	for (int k = 0; k < numberOfTurns; k++) { // loop each ring numberOfTurns

	    for (int l = 1; l <= maxRing; l++) {
		ring = l;
		int startDomain = ring - 1;
		int endDomain = size - ring;

		for (int i = 0; i < size; i++) { // outer loop
		    for (int j = 0; j < size; j++) { // inner loop

			if (i == startDomain) { // first row
			    if (j >= startDomain && j <= endDomain) { // first row within range

				this.squarelotron[i][j] = (right) ? tmpArr[size - 1 - j][startDomain]
					: tmpArr[j][endDomain];
			    } // all other elements in first row

			} else if (i == endDomain) { // last row

			    if (j >= startDomain && j <= endDomain) { // elements within range
				this.squarelotron[i][j] = (right) ? tmpArr[size - 1 - j][endDomain]
					: tmpArr[j][startDomain];
			    } // all other elements in last row//
			}

			else if (i > startDomain && i < endDomain) {

			    if (j == endDomain) { // in between rows -Right column
				// process middle rows first and last here
				this.squarelotron[i][j] = (right) ? tmpArr[startDomain][i]
					: tmpArr[endDomain][size - 1 - i];
			    } else if (j == startDomain) { // in between rows first column
				this.squarelotron[i][j] = (right) ? tmpArr[endDomain][i]
					: tmpArr[startDomain][size - 1 - i];
			    }
			}
		    }
		}
	    }
	    // copy arrays to temp array
	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    tmpArr[i][j] = this.squarelotron[i][j];
		}
	    }
	}
    }

    // main
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	Squarelotron mySquarelotron = new Squarelotron(4);
	mySquarelotron.displaySquarelotron();
	System.out.println("_____________________________________________");
	mySquarelotron.upsideDownFlip(2).displaySquarelotron();
	// System.out.println("_____________________________________________");
	// mySquarelotron.mainDiagonalFlip(2).displaySquarelotron();
	System.out.println("_____________________________________________");
	mySquarelotron.displaySquarelotron();

    }

}
