package ProjectEuler;

import Toolbox.HeapAlg;
import Toolbox.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class qn24_LexicographicPermutations {
    public static void main(String[] args){
        Timer timer = new Timer();

        int[] digits = {0,1,2,3,4,5,6,7,8,9};
        HeapAlg heapAlg = new HeapAlg(digits); //creates new HeapAlg object which populates list with all permutations as strings

        ArrayList<Long> numbers = new ArrayList<>(heapAlg.list.size()); //list of numbers we will work with
        for (String a : heapAlg.list){
            numbers.add(Long.parseLong(a)); //convert all the strings to longs and add to list
        }
        Collections.sort(numbers); //sort
        System.out.println(numbers.get(1000000 - 1));

        timer.end();
    }
}
