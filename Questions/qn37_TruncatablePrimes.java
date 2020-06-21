package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

import java.util.ArrayList;

/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove
digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class qn37_TruncatablePrimes {
    public static void main(String[] args){
        Timer timer = new Timer();

        ArrayList<Integer> list = new ArrayList<>(); //list to store truncatable primes
        int check = 1;
        while (list.size() < 11){ //stop checking after finding 11th prime
            if (isTruncatablePrime(check)) list.add(check); //if truncatable prime then add to list
            check++;
        }
        System.out.println(list);

        int sum = 0;
        for (int n : list){ //add all the truncatable primes in the list to sum
            sum += n;
        }
        System.out.println(sum);

        timer.end();
    }

    private static boolean isTruncatablePrime(int n){
        if (!Prime.checkPrime(n)) return false; //if number itself isn't prime
        int copy = n; //for use in the 2nd round of checks
        if (n < 10) return false; //since single digit primes are not counted

        while (n > 9){ //first round of checks, removing the right most digit each time
            n /= 10;
            if (!Prime.checkPrime(n)) return false;
        }

        while (copy > 9){ //second round of checks, removing the left most digit
            String removeFirst = String.valueOf(copy).substring(1); //decided to just use strings and omit the first digit
            int check = Integer.parseInt(removeFirst);
            if (!Prime.checkPrime(check)) return false;
            copy = check;
        }
        return true; //if pass both checks then its a truncatable prime
    }
}
