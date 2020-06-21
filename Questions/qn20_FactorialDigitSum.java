package ProjectEuler;

import Toolbox.Timer;

import java.util.ArrayList;

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */
public class qn20_FactorialDigitSum {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 100;
        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(1); //1!
        for (int i = 2; i <= limit; i++){
            Toolbox.ArrayLists.multiplyArrayList(digits, i); //multiply list by 2 to 100
        }

        long sum = 0;
        for (int i : digits){ //add all the digits
            sum += i;
        }
        System.out.println(sum);

        timer.end();
    }
}
