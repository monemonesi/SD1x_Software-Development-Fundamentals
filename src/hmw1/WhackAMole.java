package hmw1;
import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
    // fields
    int score;
    int molesLeft;
    int attemptsLeft;

    int numAttemps;
    int gridDimension;
    char[][] moleGrid;

    // constructor
    public WhackAMole(int numAttemps, int gridDimension) {
	// TODO Auto-generated constructor stub
	this.numAttemps = numAttemps;
	this.gridDimension = gridDimension;
	moleGrid = new char[gridDimension][gridDimension];

	for (int i = 0; i < gridDimension; i++) {
	    for (int j = 0; j < gridDimension; j++) {
		moleGrid[i][j] = '*';
	    }
	}

	molesLeft = 0;
	attemptsLeft = numAttemps;

    }

    // methods
    // PLACE
    boolean place(int x, int y) {
	if (moleGrid[x][y] != '*') {
	    return false;
	} else {
	    moleGrid[x][y] = 'M';
	    molesLeft++;
	    return true;
	}
    }

    // WHACK Given a location, take a whack at that location. If that location
    void whack(int x, int y) {
	if (moleGrid[x][y] == 'M') {
	    attemptsLeft--;
	    molesLeft--;
	    score++;
	    moleGrid[x][y] = 'W';
	    System.out.println("You got it! Mole whacked!");
	} else {
	    attemptsLeft--;
	    System.out.println("Oh no, you missed it!");
	}

    }

    // print the grid for the user
    void printGridToUser() {
	char[][] moleGridToUser = new char[gridDimension][gridDimension];
	for (int i = 0; i < gridDimension; i++) {
	    for (int j = 0; j < gridDimension; j++) {
		if (moleGrid[i][j] == 'W')
		    moleGridToUser[i][j] = 'W';
		else
		    moleGridToUser[i][j] = '*';
	    }
	    System.out.println(moleGridToUser[i]);
	}

    }

    // print the complete grid
    void printGrid() {
	for (int i = 0; i < gridDimension; i++) {
	    System.out.println(moleGrid[i]);
	}
    }

    // main function
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);

	WhackAMole myWhackAMole = new WhackAMole(50, 10);
	// Place the moles
	int counterMole = 0;
	Random r = new Random();
	while (counterMole < 10) {
	    // Random coordinate creation
	    int x = r.nextInt(10);
	    int y = r.nextInt(10);
	    boolean succes = myWhackAMole.place(x, y);
	    if (succes)
		counterMole++;
	}

	myWhackAMole.printGridToUser();
	// take the whack
	while (myWhackAMole.attemptsLeft > 0) {
	    System.out.println("Whack the moles! You still have " + myWhackAMole.attemptsLeft + " attempts");
	    System.out.println("Digit the X coordinate for your whack please_(from 0 to 9)");
	    String tempX = scanner.nextLine();
	    System.out.println("Digit the Y coordinate for your whack please_(from 0 to 9)");
	    String tempY = scanner.nextLine();

	    int x = Integer.parseInt(tempX);
	    int y = Integer.parseInt(tempY);
	    if (x == -1 && y == -1) {
		System.out.println("DO YOU REALLY GIVE UP? Here were the moles");
		myWhackAMole.printGrid();
		break;
	    }
	    myWhackAMole.whack(x, y);
	    if (myWhackAMole.score==10) {
		    System.out.println("GREAT WORK! You win!");
		    break;
		}
	    // temporary display
	    myWhackAMole.printGridToUser();
	}
	
	if (myWhackAMole.attemptsLeft == 0) {
	    System.out.println("DAMN!You ended your attempts! Here were the moles");
	    myWhackAMole.printGrid();
	}
	

    }

}
