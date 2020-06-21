package ProjectEuler;

import Toolbox.Timer;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five,
then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters
and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
public class qn17NumberLetterCounts {
    public static void main(String[] args){
        Timer timer = new Timer();

        int total = 0;
        int to9 = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4; //1-9
        int to19 = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8; //10-19
        int to99 = (6 + 6 + 5 + 5 + 5 + 7 + 6 + 6) * 10 + (to9 * 8); //20-99
        //since 22 or 53 are just twenty + two and fifty + five, can count the first word together then add 1-9
        int to999 = (to9 + 9 * 7) * 100 + (to9 + to19 + to99) * 9 + 3 * 99 * 9;
        //count all the hundreds then add 1-99
        total = total + to9 + to19 + to99 + to999 + 11;

        System.out.println(total);
        timer.end();
    }
}
