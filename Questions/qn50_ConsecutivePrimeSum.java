package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

import java.util.ArrayList;

/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

997651 543 20s
 */
public class qn50_ConsecutivePrimeSum {
    static int limit = 1000000;
    static ArrayList<Integer> primes = Prime.primesUpToN(limit);
    //putting them as static variables so that it doesn't have to be reformulated every time

    public static void main(String[] args){
        Timer timer = new Timer();

        int maxChain;
        int chainLength = 0;
        for (int prime : primes){
            int length = primeChainLength(prime);
            if (length > chainLength){ //if chain length is more than current max then update values and print
                maxChain = prime;
                chainLength = length;
                System.out.println(maxChain + " " + chainLength);
            }
        }

        timer.end();
    }

    private static int primeChainLength(int test){
        int startOfChain;
        for (int i = 0; (startOfChain = primes.get(i)) < test; i++){ //go through the different primes up till test
            int index = i + 1;
            int sum = startOfChain;
            while (sum < test){ //add consecutive primes to sum
                sum += primes.get(index);
                index++;
            }
            if (sum == test) return index - i; //found chain
        }
        return 0; //no chain found
    }
}
