
package hmw4;

import java.util.Scanner;

public class BattleshipGame {
    

    public static void main(String[] args) {
	boolean gameOn=true;
	Scanner scnr = new Scanner(System.in);
	Ocean myOcean = new Ocean();
	System.out.println("Welcome to this solo version of the battleship game!");
	System.out.println("This is your ocean, shoot for sunk the enemy ships!");
	myOcean.placeAllShipsRandomly();
	myOcean.print();
	
	while (gameOn) {
		
		System.out.println("take your 5 shoots");
		System.out.println("please use this format:");
		System.out.println("x1,y1; x2,y2; x3,y3; x4,y4; x5,y5");
		System.out.println("press q for quit");
		String input = scnr.nextLine();
		if (input.equals("q")) {
			System.out.println("Game over!");
			break;
		}
		String[] pairs = input.split("; ");
		for (String shootLoc : pairs) {
			String[] locations = shootLoc.split(",");
			if (myOcean.shootAt(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]))) {
				System.out.println("hit");
			} else {
				System.out.println("miss");
			}
		}
		myOcean.print();
		
		if (myOcean.isGameOver()) {
			System.out.print("Game over! Do you want play again? y or n: ");
			input = scnr.nextLine();
			if (input.equals("y")) {
			    myOcean = new Ocean();
			    myOcean.placeAllShipsRandomly();
			} else {
				System.out.println("Total shot fired: " + myOcean.getShotsFired());
				break;
			}
		}
		
		
		
		
	} //end of GameOn
	 

    }

}

