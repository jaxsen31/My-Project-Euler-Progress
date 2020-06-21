package ProjectEuler;

import Toolbox.Timer;

import java.util.HashMap;
import java.util.Map;

/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing
two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class qn33_DigitCancellingFractions {
    public static void main(String[] args){

        Timer timer = new Timer();

        System.out.println(isDCF(49,98));
        System.out.println(isDCF(30,50));
        //checking function

        HashMap<Integer, Integer> fractions = new HashMap<>(); //using map so that can store 2 values
        for (int num = 1; num < 100; num++){
            for (int denom = num + 1; denom < 100; denom++){
                if (isDCF(num,denom)) fractions.put(num, denom); //add to map if its DCF
            }
        }

        for (Map.Entry<Integer, Integer> entry : fractions.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue()); //printing all the fractions
        }

        long productNumerator = 1;
        long productDenominator = 1;
        for (Map.Entry<Integer, Integer> entry : fractions.entrySet()){
            //basically multiplying all the fractions together
            productNumerator *= entry.getKey();
            productDenominator *= entry.getValue();
        }
        System.out.println(productNumerator + "/" + productDenominator); //just divide from the displayed numbers


        timer.end();
    }

    private static boolean isDCF(int numerator, int denominator){
        if (numerator > denominator) return false; //fraction must be less than 1
        if (numerator % 10 == 0 && denominator % 10 == 0) return false; //trivial example
        double original = 1.0 * numerator / denominator; //original fraction
        double DCF = 1.0 * (numerator / 10) / (denominator % 10); //fraction obtained by cancelling digits
        return original == DCF && numerator % 10 == denominator / 10;
    }
}
