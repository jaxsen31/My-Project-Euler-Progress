package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 */
public class qn35_CircularPrimes {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1000000;
        int count = 0;
        for (int i = 2; i < limit; i++){
            if (isCircular(i)){ //check through every number up to limit, if true then increment count
                count++;
            }
        }
        System.out.println(count);

        timer.end();
    }

    private static boolean isCircular(int n){
        if (!Prime.checkPrime(n)) return false; //if number isn't prime then is false
        if (n < 10) return true; // if testing single digit number then automatically true

        int test = n; //variable to keep track of number after having rotated the numbers
        int length = String.valueOf(n).length();
        int rotations = 1; //start at 1 since the original number already tested for primality
        while (rotations < length) { //loop such that every digit would have been shifted
            int lastDigit = test % 10;
            int rest = test / 10;
            int newNumber = lastDigit * (int) Math.pow(10, length - 1) + rest; //test number post-shift
            if (!Prime.checkPrime(newNumber)) return false;
            test = newNumber; //storing the new number into test
            rotations++;
        }
        return true;
    }
}
