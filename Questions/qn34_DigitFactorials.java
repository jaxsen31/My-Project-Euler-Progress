package ProjectEuler;

import Toolbox.PnC;
import Toolbox.Timer;

/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class qn34_DigitFactorials {
    public static void main(String[] args){
        Timer timer = new Timer();

        long factorial9 = PnC.factorial(9);
        long factorial9s = factorial9;
        long limit = 9;
        while (factorial9s > limit){
            limit *= 10;
            limit += 9;
            factorial9s += factorial9;
        }
        System.out.println(limit);
        //establishing limit for search
        //assuming every digit is 9, the limit should be more than the sum of 9 factorial * length

        long total = 0;
        for (long i = 3; i < limit; i++){ //going over every number up to limit
            if (isCurious(i)) {
                System.out.println(i);
                total += i; //if is curious then print and add to running total
            }
        }
        System.out.println(total);

        timer.end();
    }

    private static boolean isCurious(long n){
        String[] digits = String.valueOf(n).split(""); //split into its digits
        long factorialTotal = 0;
        for (String digit : digits){
            int number = Integer.parseInt(digit); //parse each digit into an int and then add its factorial into total
            factorialTotal += PnC.factorial(number);
        }
        return factorialTotal == n;
    }
}
