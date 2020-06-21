package ProjectEuler;

import Toolbox.Palindrome;
import Toolbox.Timer;

/*
A palindromic number reads the same both ways.
The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class qn04_LargestPalindromProduct {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1000;
        long max = 0;
        for (int a = limit - 1; a > limit / 10; a--){
            for (int b = a - 1; b > limit / 10; b--){
                //starting from 999 and going down with the checking
                long n = a * b; //supposed palindrome
                if (Palindrome.isPalindromic(String.valueOf(n))){
                    if (n > max) {
                        max = n;
                        System.out.println(n + " " + a + " " + b);
                    }
                }
            }
        }

        System.out.println(max);
        timer.end();
    }
}
