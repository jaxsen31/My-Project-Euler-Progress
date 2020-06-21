package ProjectEuler;

import Toolbox.Timer;

import java.util.Arrays;

/*
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576.
We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with
(1,2, ... , n) where n > 1?
 */
public class qn38_PandigitalMultiples {
    public static void main(String[] args){
        Timer timer = new Timer();

        long largestPandigital = 0;
        for (int i = 2; i < 10000; i++){ //limiting to 4 digit numbers cause 2 5-digit numbers concatenated will be more than 9 digit long
            StringBuilder build = new StringBuilder();
            int multiple = 1;
            while (build.length() < 9){ //adding multiples onto the string builder
                build.append(i * multiple);
                multiple++;
            }
            if (build.length() > 9) continue; //if more than 9 digits then continue to next value of i
            long pandigital = Long.parseLong(build.toString());
            if (pandigital < largestPandigital) continue; //if pandigital value for this i is less than current highest then just continue
            if (isPandigital(pandigital)){
                largestPandigital = pandigital;
                System.out.println(i + " " + pandigital);
            }
        }
        System.out.println(largestPandigital);

        timer.end();
    }

    private static boolean isPandigital(long n){
        String[] digits = String.valueOf(n).split(""); //split long into its digits
        if (digits.length != 9) return false; //if not 9 digits long then false
        Arrays.sort(digits);
        for (int i = 0; i < 9; i++){
            if (Integer.parseInt(digits[i]) != i + 1) return false; //verifying that every element = index + 1
        }
        return true;
    }
}
