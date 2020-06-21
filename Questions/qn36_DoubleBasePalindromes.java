package ProjectEuler;

import Toolbox.Palindrome;
import Toolbox.Timer;

/*
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

 */
public class qn36_DoubleBasePalindromes {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1000000;
        long sum = 0;
        for (int i = 1; i < limit; i++){
            if (Palindrome.isPalindromic(String.valueOf(i)) && Palindrome.isPalindromic(Integer.toBinaryString(i))){
                //if both the number being tested and its binary version is palindromic
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);

        timer.end();
    }
}
