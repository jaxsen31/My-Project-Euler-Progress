package ProjectEuler;

import Toolbox.HeapAlg;
import Toolbox.Timer;

/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order,
but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class qn43_SubStringDivisibility {
    public static void main(String[] args){
        Timer timer = new Timer();

        int[] digits = new int[10];
        for (int i = 0; i < 10; i++){ //digits for this pandigital number is 0 - 9
            digits[i] = i;
        }
        HeapAlg heapAlg = new HeapAlg(digits); //creates list of all permutations for digits
        long total = 0;
        for (String perm : heapAlg.list){ //scrub through list
            int divisible = Integer.parseInt(perm.substring(1,4)); //run through each test using the specific substring
            if (divisible % 2 != 0) continue;
            divisible = Integer.parseInt(perm.substring(2,5));
            if (divisible % 3 != 0) continue;
            divisible = Integer.parseInt(perm.substring(3,6));
            if (divisible % 5 != 0) continue;
            divisible = Integer.parseInt(perm.substring(4,7));
            if (divisible % 7 != 0) continue;
            divisible = Integer.parseInt(perm.substring(5,8));
            if (divisible % 11 != 0) continue;
            divisible = Integer.parseInt(perm.substring(6,9));
            if (divisible % 13 != 0) continue;
            divisible = Integer.parseInt(perm.substring(7,10));
            if (divisible % 17 != 0) continue;

            //if pass all tests, print and add to running total
            System.out.println(perm);
            total += Long.parseLong(perm);
        }

        System.out.println(total);

        timer.end();
    }
}
