package extra;

import java.util.Scanner;

public class Game {
    /* Guessing game
       The computer randomly selects a number
       between 1000 and 9999.
       Stage 0:
           The player has to guess the number
           with no hints provided.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play a game!");

        int secretNumber = (int) (Math.random() * 9000) + 1000;

        for (int i=0; i<50; i++) {
            if (i == 17) continue;
            System.out.println();
        }

        while (true) {
            System.out.print("Please enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                break;
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
        }

    }
}
