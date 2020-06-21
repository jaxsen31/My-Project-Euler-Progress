package ProjectEuler;

import Toolbox.Timer;

/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */
public class qn09_SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        Timer timer = new Timer();

        for (int a = 1; a <= 998; a++) {
            for (int b = a + 1; b <= 998; b++) {
                int c = 1000 - a - b;
                //generate triplet a b and c
                if (c < a || c < b){
                    break;
                    //since c is 'hypotenuse', has to be bigger than a and b
                }
                if (a * a + b * b == c * c) {
                    System.out.println(a + " " + b + " " + c);
                    System.out.println(a * b * c);
                    timer.end();
                    return; //didnt know how to break from 2 nested loops so used return instead
                }
            }
        }
    }

    private static boolean checkSquare(long n){
        long sqrt = (long) Math.sqrt(n);
        return n == sqrt * sqrt;
    }
}
