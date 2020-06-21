package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */
public class qn07_100001Prime {
    public static void main(String[] args){
        Timer timer = new Timer();

        System.out.println(Prime.nthPrime(10001));

        timer.end();
    }
}
