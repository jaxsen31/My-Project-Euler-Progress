package Toolbox;

public class Fibonacci {
    static int fib0 = 0;
    static int fib1 = 1;

    public static long nthFibonacci(long i){
        if (i == 1){
            return 1;
        }
        long previous = fib1;
        long previous2 = fib0;
        long result = 0;
        for (int n = 2; n <= i; n++){
            result = previous + previous2;
            previous2 = previous;
            previous = result;
        }
        return result;
    }
}
