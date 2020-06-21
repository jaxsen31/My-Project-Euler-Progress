package ProjectEuler;

import Toolbox.Timer;
import java.util.ArrayList;

/*
In the United Kingdom the currency is made up of pound (£) and pence (p).
There are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
 */
public class qn31_CoinSums {
    public static void main(String[] args) {
        Timer timer = new Timer();

        int amount = 200; //amount to be split
        ArrayList<Integer> denominations  = new ArrayList<>();
        denominations.add(200);
        denominations.add(100);
        denominations.add(50);
        denominations.add(20);
        denominations.add(10);
        denominations.add(5);
        denominations.add(2);
        denominations.add(1);
        //all the different denomination values
        //have to add in descending order due to split function

        System.out.println(split(amount, denominations));

        timer.end();
    }

    public static int split(int total, ArrayList<Integer> denominations) { //recursive method to find ways to split
        if (total == 0){
            return 1; //if remainder is exactly 0 means that this 'path' is valid
        } else if (total < 0 || denominations.size() == 0){
            return 0;
            //if remainder less than 0 means that the total in this 'path' is more than the amount to split
            //2nd condition is to terminate the 'path'
        } else {
            int count = 0;
            count += split(total - denominations.get(0), denominations); //count again with total minus largest current denomination

            ArrayList<Integer> newDenominations = new ArrayList<>(denominations);
            newDenominations.remove(0); //copied the old denominations and removed the largest one
            count += split(total, newDenominations); //count again with the total but without largest current denomination
            return count;
        }
    }
}
