package ProjectEuler;

import Toolbox.Prime;
import Toolbox.Timer;

import java.util.*;

/*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class qn49_PrimePermutations {
    public static void main(String[] args){
        Timer timer = new Timer();

        HashMap<ArrayList<Integer>, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> primes = Prime.primesUpToN(10000);
        for (int prime : primes){
            if (prime < 1000) continue;
            ArrayList<Integer> digits = new ArrayList<>(4);
            for (int i = 0; i < 4; i++){
                digits.add((int) String.valueOf(prime).charAt(i) - 48);
            }

            Collections.sort(digits);
            if (map.containsKey(digits)){
                ArrayList<Integer> originalList = map.get(digits);
                originalList.add(prime);
                map.put(digits, originalList);
            } else {
                ArrayList<Integer> newList = new ArrayList<>(1);
                newList.add(prime);
                map.put(digits, newList);
            }
        }

        for (ArrayList<Integer> primePermutations : map.values()){
            checkAP(primePermutations);
        }

        timer.end();
    }

    private static void checkAP(ArrayList<Integer> primeSet){
        for (int i = 0; i < primeSet.size() - 1; i++){
            int test = primeSet.get(i);
            for (int n = i + 1; n < primeSet.size(); n++){
                int comparison = primeSet.get(n);
                int middle = (test + comparison) / 2;
                if (primeSet.contains(middle)) System.out.println(test + "" + middle + "" + comparison);
            }
        }
    }
}
