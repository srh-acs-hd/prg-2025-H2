public class Fibonacci {
    /*
        Q1: Messure the time for some big input of n
        Q2: Can you improve the performance of this program ?
     */ 
    public static void main(String[] args) {
        int n = 47;
        System.out.print("fibonacci("+ n +") = " + fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


}
