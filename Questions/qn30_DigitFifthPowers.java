package ProjectEuler;

import Toolbox.Timer;

/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class qn30_DigitFifthPowers {
    public static void main(String[] args){
        Timer timer = new Timer();

        int power = 5;
        int limit = 9; //need to find actual limit of search
        int power9 = (int) Math.pow(9,power);
        while (String.valueOf(limit).length() * power9 > limit){
            //alter value of limit until its value is more than the sum of fifth powers of its digits
            limit *= 10;
            limit += 9;
            //adding another 9 to the end of limit
        }
        System.out.println(limit); //altered limit is 999999 (6 digits)

        long total = 0;
        for (long i = 10L; i < limit; i++){ //start at 10 since all single digit numbers do not count as sums
            String[] digits = String.valueOf(i).split(""); //split the number we're checking (i) into its individual digits
            long sumDigits = 0;
            for (String digit : digits){
                sumDigits += Math.pow(Integer.parseInt(digit), power); //add each digit raised to power 5 to the sumDigits
            }
            if (sumDigits == i) total += i; //if equal then add to running total
        }
        System.out.println(total);

        timer.end();
    }
}
