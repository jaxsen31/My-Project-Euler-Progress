package ProjectEuler;

import Toolbox.Timer;

import java.util.ArrayList;

/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 */
public class qn16_PowerDigitSums {
    public static void main(String[] args){
        Timer timer = new Timer();

        int power;
        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(2); //setting the digits to 2^1
        for (power = 2; power <= 1000; power++){
            Toolbox.ArrayLists.multiplyArrayList(digits, 2);
        }
        //multiplied the list of digits to 2^1000
        long sum = 0;
        for (int i : digits){ //adding all the digits
            sum += i;
        }
        System.out.println(sum);

        timer.end();
    }
}
