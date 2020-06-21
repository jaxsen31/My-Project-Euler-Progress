package ProjectEuler;

import Toolbox.Timer;

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */
public class qn21_AmicableNumbers {
    public static void main(String[] args){
        Timer timer = new Timer();

        long sum = 0;
        int limit = 10000;
        for (int i = 1; i < limit; i++){
            int comparison = properDivisorsSum(i); //if i = 220, comparison would be 284
            if (i != comparison && i == properDivisorsSum(comparison)) sum += i; //if they're equal, add the i value to sum
        }
        System.out.println(sum);

        timer.end();
    }

    public static int properDivisorsSum(int n){
        int sum = 1;
        for (int i = 2; i <= n / 2; i++){ //loop until n/2 for proper divisors
            if (n % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
