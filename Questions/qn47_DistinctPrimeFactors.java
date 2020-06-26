package ProjectEuler;

import Toolbox.PrimeFactors;
import Toolbox.Timer;

/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */
public class qn47_DistinctPrimeFactors {
    public static void main(String[] args){
        Timer timer = new Timer();

        int number = 4; //this is for the number of consecutive numbers with this value of distinct prime factors
        int firstNumber = 1;
        while (!checkIntegers(firstNumber, number)) { //scrub through all the numbers
            firstNumber++;
        }
        System.out.println(firstNumber);
        timer.end();
    }

    private static boolean checkIntegers(int firstNumber, int number){
        for (int i = 0; i < number; i++){ //goes through 'number' consecutive numbers
            int check = firstNumber + i;
            if (PrimeFactors.uniquePrimeFactors(check).size() != number) return false; //if this number doesn't have 'number' distinct PF
        }
        return true;
    }
}
