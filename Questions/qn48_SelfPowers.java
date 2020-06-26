package ProjectEuler;

import Toolbox.ArrayLists;
import Toolbox.Timer;

import java.util.ArrayList;

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class qn48_SelfPowers {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1000;
        ArrayList<Integer> digits = new ArrayList<>(); //digits for the final sum
        digits.add(1); //start by adding 1^1

        for (int i = 2; i <= limit; i++){ //add all the other self powers
            ArrayList<Integer> power = new ArrayList<>(); //digits for this self power
            for (String n : String.valueOf(i).split("")){ //add the number itself into power aka i^1
                power.add(Integer.parseInt(n)); //do this for numbers that are more than 1 digit long
            }
            for (int n = 2; n <= i; n++) {
                ArrayLists.multiplyArrayList(power, i); //raise it to its own power
            }
            digits = ArrayLists.add2ArrayLists(digits, power); //add self power to running total
        }

        for (int i = digits.size() - 10; i < digits.size(); i++){
            System.out.print(digits.get(i)); //print last 10 digits
        }
        System.out.println();

        timer.end();
    }
}
