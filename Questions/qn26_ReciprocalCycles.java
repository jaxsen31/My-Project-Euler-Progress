package ProjectEuler;

import Toolbox.Timer;

import java.util.ArrayList;

/*
A unit fraction contains 1 in the numerator.
The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class qn26_ReciprocalCycles {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1000;
        int maxChain = 0;
        int d = 0;
        for (int i = 2; i < limit; i++){
            int chainLength = chainLength(i); //get length for 1/i
            if (chainLength > maxChain){
                maxChain = chainLength;
                d = i;
            }
        }
        System.out.println(d + "->" + maxChain);

        timer.end();
    }

    private static int chainLength(int n){
        if (n % 2 == 0 || n % 5 == 0){ //confirm too short
            return 0;
        }
        ArrayList<Integer> checked = new ArrayList<>();
        //list of numbers that n have been divided by
        //each number can only appear once, if 2nd time means 2nd loop already (line 57)
        checked.add(1);
        return check(n, 1, checked);
    }

    private static int check(int n, int remainder, ArrayList<Integer> checked){
        int divisor = remainder * 10;
        int left = divisor % n;
        if (checked.contains(left)){
            return checked.size();
        } else {
            checked.add(remainder);
            return check(n, left, checked);
        }
    }
}
