package ProjectEuler;

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */

import Toolbox.Timer;

public class qn01_Multiple3or5 {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1000;
        int sum = 0;
        for (int i = 3; i < limit; i++){
            if (i % 3 == 0 || i % 5 == 0){
                //divisible by either 3 or 5
                sum += i;
            }
        }
        System.out.println(sum);
        timer.end();
    }
}
