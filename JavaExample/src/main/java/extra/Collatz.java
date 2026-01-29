package extra;

import java.util.Scanner;

public class Collatz {
    /*
        Q1 : Will this program terminate for every input of n ?
        Q2:  Determine the loop count for some input of n
        Q3:  What is the maximum loop count for all positive n > 0 ?
    */
    public static void main(String[] args) {
        long maxLoopCount = 0;
        long numberWithMaxLoopCount = 0;

        for (int i=1; i<=Integer.MAX_VALUE; i++) {
            long n = i;
            long loopCount = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n/2;
                }
                else {
                    n = 3*n + 1;
                }
                loopCount++;
            }

            if (loopCount > maxLoopCount) {
                System.out.println(i + " -> " + loopCount);
                maxLoopCount = loopCount;
                numberWithMaxLoopCount = i;
            }
        }
        System.out.println("Maximum loop count is " + maxLoopCount + " for number " + numberWithMaxLoopCount);
    }
}
