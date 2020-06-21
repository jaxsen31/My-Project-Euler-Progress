package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

import java.util.ArrayList;

/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */
public class qn10_SummationOfPrimes {
    public static void main(String[] args){
        Timer timer = new Timer();

        long limit = 2000000;
        ArrayList<Long> primesUpToLimit = Prime.primesUpToN(limit); //using this function was the crux
        long total = 0;
        for (long i : primesUpToLimit){
            total += i;
        }
        System.out.println(total);

        timer.end();
    }
}
