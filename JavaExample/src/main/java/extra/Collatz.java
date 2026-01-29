package extra;

import java.util.Scanner;

public class Collatz {
    /*
        Q1 : Will this program terminate for every input of n ?
        Q2:  Determine the loop count for some input of n
        Q3:  What is the maximum loop count for all positive n > 0 ?
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter n: ");
        int n = scanner.nextInt();

        int loopCount = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n/2;
            }
            else {
                n = 3*n + 1;
            }
            loopCount++;
        }

        System.out.println("Collatz sequence number for " + n + " is " + loopCount);
    }
}
