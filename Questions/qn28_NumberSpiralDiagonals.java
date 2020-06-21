package ProjectEuler;

import Toolbox.Timer;

/*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class qn28_NumberSpiralDiagonals {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 1001;
        long total = 1L;
        for (int i = 3; i <= limit; i += 2){ //from the second inner square and count outwards
            int square = i * i; //top right corner is the square of an odd number : 1, 3, 5 ...
            total = total + square + (square - (i-1)) + (square - 2 * (i-1)) + (square - 3 * (i-1));
            //every corner of the square differs by (length of square) - 1
        }
        System.out.println(total);

        timer.end();
    }
}
