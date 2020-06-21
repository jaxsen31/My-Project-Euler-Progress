package ProjectEuler;

import Toolbox.Timer;

/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If d_n represents the nth digit of the fractional part, find the value of the following expression.

d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
 */
public class qn40_ChampernownesConstant {
    public static void main(String[] args){
        Timer timer = new Timer();

        StringBuilder build = new StringBuilder();
        int i = 0; //started at 0 to offset index -> want 12th digit just find 12th index
        while (build.length() <= 1000000){
            build.append(i);
            i++;
        }
        System.out.println(build.charAt(12)); //should be 1

        int multiple = 1;
        for (int n = 0; n <= 6; n++){
            multiple *= (build.charAt((int) Math.pow(10,n)) - 48);
            //multiply all the digits in question, minus 48 as char value for 1 is 49
        }
        System.out.println(multiple);

        timer.end();
    }
}
