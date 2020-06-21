package ProjectEuler;

import Toolbox.Timer;

/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class qn14_LongestCollatzSequence {
    public static void main(String[] args){
        Timer timer = new Timer();

        long limit = 1000000;
        long maxLength = 0;
        long startingValue = 0;
        for (long i = 2; i < limit; i++){ //searching through all the numbers up to 1 mil
            long length = collatz(i,1); //function returns the length of the sequence for i
            if (length > maxLength){ //update max
                maxLength = length;
                startingValue = i;
            }
        }
        System.out.println(startingValue + " has " + maxLength + " iterations");

        timer.end();
    }

    private static long collatz(long n, long iterations){
        if (n == 1){
            return iterations;
        }
        iterations++;
        long newN;
        if (n % 2 == 0){
            newN = n / 2;
        } else {
            newN = 3 * n + 1;
        }
        return collatz(newN,iterations);
    }
}
