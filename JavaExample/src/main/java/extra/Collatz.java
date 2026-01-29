package extra;

import java.util.Scanner;

public class Collatz {
    /*
        Q1 : Will this program terminate for every input of n ?
        Q2:  Determine the loop count for some input of n
        Q3:  What is the maximum loop count for all positive n > 0 ?
    */

    private static final int MAX_N_VALUE = 1_000_000_000;
    public static void main(String[] args) {
        long maxLoopCount = 0;
        long numberWithMaxLoopCount = 0;
        int[] memory = new int[MAX_N_VALUE]; // array will be initialized to 0

        long startTime = System.currentTimeMillis();
        for (int i=1; i<=MAX_N_VALUE; i++) {
            long n = i;

            long loopCount = 0;
            while (n != 1) {
                if (n < MAX_N_VALUE && memory[ (int)n-1 ] > 0) {
                    loopCount += memory[ (int)n-1 ];
                    break;
                }

                if (n % 2 == 0) {
                    n = n/2;
                }
                else {
                    n = 3*n + 1;
                }
                loopCount++;
            }
            memory[i-1] = (int)loopCount;

            if (loopCount > maxLoopCount) {
                System.out.println(i + " -> " + loopCount);
                maxLoopCount = loopCount;
                numberWithMaxLoopCount = i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Maximum loop count is " + maxLoopCount + " for number " + numberWithMaxLoopCount);
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}
