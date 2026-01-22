package extra;

import java.util.Scanner;

public class Game {
    /* Guessing game
       The computer randomly selects a number
       between 1000 and 9999.
       Stage 0:
           The player has to guess the number
           with no hints provided.
        Stage 1:
            The player can exit with 0 as input,
            and the number of attempts is counted and printed.
        Stage 2:
            The player receives feedback on whether their guess
            is too high or too low.
        Stage 3:
            Dismiss stage 2, but give the player another feedback:
            - if a digit is present and on the correct spot, display a star
            - if a digit is present and not on the correct spot, display a circle
            - otherwise dont display anything
            e.g.
             secret number: 1234
             guess:         1572 => *o
             guess:         7243 => *oo
            Warning: As a coding constraints: DO NOT USE STRING OPERATIONS
     */
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play a game!");

        int secretNumber = (int) (Math.random() * 9000) + 1000;
        int numberOfAttempts = 0;

        while (true) {
            System.out.print("Please enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == 0) {
                System.out.println("Thank you for playing");
                System.out.println("The secret number was " + secretNumber);
                break;
            }

            numberOfAttempts++;
            if (guess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                break;
            } else if (guess > secretNumber) {
                System.out.println("Too bad, your number is too high");
            } else {
                System.out.println("Too bad, your number is too low");
            }
        }
        // DRY - Don't repeat yourself, do not WET (Write everything twice)
        System.out.println("You needed " + numberOfAttempts + " number of attempts.");
    }
}

/* Binary Search
    1) Use a value in the middle of the search space
    2) check the number, if it is the searched number, quit
    3) if the number is lower than the searched one use the right hand part (higher values)
    4) otherwise use the left hand part (lower values)
    5) goto step 1
 */