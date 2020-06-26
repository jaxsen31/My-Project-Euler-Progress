package ProjectEuler;

import Toolbox.HeapAlg;
import Toolbox.Prime;
import Toolbox.Timer;

import java.util.ArrayList;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 */
public class qn41_PandigitalPrime {
    public static void main(String[] args){
        Timer timer = new Timer();

        long largestPandigitalPrime = 0;
        int n = 9; //starting from n = 9 and working downwards
        while (largestPandigitalPrime == 0){ //stop searching once we've found a pandigital prime
            int[] digits = new int[n];
            for (int i = 0; i < n; i++){ //fill digits with numbers from 1 to n
                digits[i] = i + 1;
            }
            HeapAlg heapAlg = new HeapAlg(digits); //using heap algorithm to produce all the pandigital permutations
            for (String permutation : heapAlg.list){
                long test = Long.parseLong(permutation);
                if (test > largestPandigitalPrime && Prime.checkPrime(test)){
                    //if current pandigital permutation is more than the record and is prime
                    largestPandigitalPrime = test;
                }
            }
            n--; //if cant find any for this value of n, go one value lower
        }
        System.out.println(largestPandigitalPrime);

        timer.end();
    }
}
