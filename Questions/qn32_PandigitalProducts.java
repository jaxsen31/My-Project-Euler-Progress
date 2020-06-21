package ProjectEuler;

import Toolbox.Timer;

import java.util.HashSet;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand,
multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class qn32_PandigitalProducts {
    static HashSet<Integer> digits = new HashSet<>();
    static{
        for (int i = 1; i <= 9; i++) digits.add(i);
    }

    public static void main(String[] args){
        Timer timer = new Timer();

        System.out.println(isPandigital("837261459")); //check if function works
        System.out.println(isPandigital("8372614590")); //extra 0
        System.out.println(isPandigital("837221459")); //repeat of 2

        HashSet<Integer> pandigitalProducts = new HashSet<>(); //using sets so that there's no duplicates
        for (int a = 1; a < 100; a++){
            int aLength = String.valueOf(a).length();
            for (int b = a + 1; b < (int) Math.pow(10, 5 - aLength); b++){
                //since when combined, it has to be 9 digits, furthest you can go is a and b take up 5 digits, then product is 4 digits
                int product = a * b;
                String combined = a + String.valueOf(b) + product;
                if (!isPandigital(combined)) continue; //if not pandigital then continue to next value of b
                pandigitalProducts.add(product);
            }
        }

        int sum = 0;
        for (int l : pandigitalProducts){ //add all the numbers in the hashset
            sum += l;
        }
        System.out.println(sum);

        timer.end();
    }

    private static boolean isPandigital(String n){
        if (n.length() != 9) return false; //n must be 9 digits long to be pandigital

        String[] digit = n.split("");
        HashSet<Integer> numbers = new HashSet<>();
        for (String d : digit){
            numbers.add(Integer.valueOf(d)); //add every digit into the hashset
        }
        if (numbers.size() != 9) return false; //means there were duplicates
        return numbers.equals(digits);
    }
}
