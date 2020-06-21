package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

import java.util.ArrayList;

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class qn05_SmallestMultiple {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 20;
        ArrayList<Integer> primes = Prime.primesUpToN(limit); //generate list of primes up to 20
        int lowerLimit = 1;
        for (int i : primes){
            lowerLimit *= i;
        }
        //get lower limit of search by multiplying all the primes up to 20
        //number we want will be more because power of each prime may be more than 1

        while (!check(lowerLimit, limit)){
            lowerLimit++;
        }
        //starting with the lower limit, check if it can be divided by all numbers up to 20
        //if cant, then it will check the next number
        System.out.println(lowerLimit);

        timer.end();
    }

    private static boolean check(int test, int limit){
        for (int i = 2; i <= limit; i++){
            if (test % i != 0){
                return false;
            }
        }
        return true;
    }
}
