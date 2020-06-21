package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

/*
Euler discovered the remarkable quadratic formula:

n2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39.
However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41 is clearly divisible by 41.

The incredible formula n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79.
The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n2+an+b, where |a|<1000 and |b|≤1000

where |n| is the modulus/absolute value of n
e.g. |11|=11 and |−4|=4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes
for consecutive values of n, starting with n=0.
 */
public class qn27_QuadraticPrimes {
    public static void main(String[] args){
        Timer timer = new Timer();

        System.out.println(checkNumberPrimes(1, 41));
        System.out.println(checkNumberPrimes(-79, 1601));
        //checking if function works using examples given
        int aLimit = 999;
        int bLimit = 1000;
        int maxNumPrimes = 0;
        long multiplied = 0;

        for (int a = -aLimit; a <= aLimit; a++){
            for (int b = -bLimit; b <= bLimit; b++){
                //scrubbing through all the numbers within limit -> start from negative limit cause range is given as modulus
                int numberOfPrimes = checkNumberPrimes(a, b);
                if (numberOfPrimes > maxNumPrimes){ //if more than current highest then update
                    System.out.println(a + " " + b + " " + numberOfPrimes);
                    maxNumPrimes = numberOfPrimes;
                    multiplied = a * b;
                }
            }
        }
        System.out.println(multiplied);
        timer.end();
    }

    private static int checkNumberPrimes(int a, int b){
        int n = 1;
        while (true){
            long number = n * n + a * n + b; //number for that value of n
            if (number < 0 || !Prime.checkPrime(number)){ //if n less than 0 or not prime
                break;
            }
            n++;
        }
        return n;
    }
}
