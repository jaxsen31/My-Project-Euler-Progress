package ProjectEuler;

import Toolbox.Timer;

import java.util.ArrayList;

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called
abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written
as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers
greater than 28123 can be written as the sum of two abundant numbers.
However, this upper limit cannot be reduced any further by analysis even though
it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class qn23_NonAbundantSums {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 28123; //limit as given in qn
        ArrayList<Integer> abundantNumbers = new ArrayList<>(); //list of abundant numbers
        for (int i = 12; i <= limit - 12; i++){ //filling the list
            if (isAbundant(i)){
                abundantNumbers.add(i);
            }
        }
        System.out.println(abundantNumbers);
        ArrayList<Integer> numbersToRemove = new ArrayList<>();
        for (int i = 24; i <= limit; i++){ //checking numbers that could be written as sum
            for (int n : abundantNumbers){ //running through the list of abundant numbers
                if (n >= i) break; //if abundant number bigger than number being checked, means this number cannot be written as a sum
                int remainder = i - n;
                if (abundantNumbers.contains(remainder)) { //means it can be written as sum
                    numbersToRemove.add(i); //add to list
                    System.out.println(i + " " + n + " " + remainder);
                    break;
                }
            }
        }

        long total = limit * (limit + 1) / 2; //adding up all the numbers from 1 to 28123
        for (int i : numbersToRemove){ //removing those from the list
            total -= i;
        }
        System.out.println(total);
        timer.end();
    }

    private static boolean isAbundant(int n){
        int sum = 1;
        for (int i = 2; i <= n / 2; i++){ //loop until n/2 for proper divisors
            if (n % i == 0){
                sum += i;
            }
        }
        return sum > n; //is abundant if sum of proper divisors are more than number
    }
}
