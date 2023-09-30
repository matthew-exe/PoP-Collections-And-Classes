import java.util.Scanner;

/**
 * Craps Class
 * @author Matthew Gee
 * @since November 2022
 *
 * Creates two Dice objects and uses them to play the craps game.
 */
public class Craps {

    static Dice dice1 = new Dice(); // new dice object
    static Dice dice2 = new Dice(); // new dice object

    /**
     * shoot()
     * rolls both dice objects
     */
	public void shoot() {
        dice1.roll();
        dice2.roll();
	}


    /**
     * getDice1()
     * gets dice one
     * @return dice1 as a Dice object
     */
	public Dice getDice1() {
		return dice1;
	}


    /**
     * getDice2()
     * gets dice two
     * @return dice2 as a Dice object
     */
	public Dice getDice2() {
        return dice2;
	}


    /**
     * addupScore()
     * adds up both dices face values
     * @return the total of both dices face value
     */
	public int addUpScore() {
		return dice1.getFaceValue() + dice2.getFaceValue();
	}


    /**
     * decideOutcome()
     * works out the users result based on the Craps rules
     * @param score     total face value of both dice
     * @return whether the user won, lost or needs to roll again
     */
	public String decideOutcome(int score) {
		String result;
        if (score == 7 || score == 11) {
            result = "You win";
        }
        else if (score == 2 || score == 3 || score == 12) {
            result = "You lose";
        }
        else {
            result = "Throw again";
        }
        return result;
	}


    /**
     * getResults()
     * rolls the dice and formats the dice one and two values and total score as well as the result into one string
     * @return string to be outputted to the user
     */
	public String getResults() {
        String outputString;
        shoot();
        outputString =  "\n**************" +
                        "\nDice 1 is " + getDice1() +
                        "\nDice 2 is " + getDice2() +
                        "\nTotal is: " + addUpScore() +
                        "\nResult is " + decideOutcome(addUpScore());
        return outputString;
    }


    /**
     * playCraps()
     * keeps rolling the dice and getting a new result until the result is not throw again
     * @return all the results in one string
     */
	public String playCraps() {
		StringBuilder outputString = new StringBuilder();
        do {
            outputString.append(getResults()); // adding result to string
        } while (decideOutcome(addUpScore()).equals("Throw again"));
        return outputString.toString();
	}


    /**
     * playAgain()
     * runs the craps game and then asks the user if they would like to play again
     */
	public void playAgain(){
        String userChoice = "y";
        Scanner keyboard = new Scanner(System.in); // new keyboard scanner
        while (!userChoice.equals("n")) {
            System.out.println(playCraps()); // runs craps game
            System.out.println("**************\nWould you like to play again (Y / N): ");
            userChoice = keyboard.next().toLowerCase(); // getting user input
        }
	}
}
