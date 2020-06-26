package ProjectEuler;

import Toolbox.Timer;

import java.util.ArrayList;

/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class qn46_GoldbachsOtherConjecture {
    static ArrayList<Integer> primes = new ArrayList<>(); //arraylist to keep track of primes already checked
    static {
        primes.add(2);
    }

    public static void main(String[] args){
        Timer timer = new Timer();

        int i = 3; //since its going to have to be odd, just start with 3 and use increments of 2
        while (true){
            if (isPrime(i)) {
                primes.add(i); //if prime, add to list and don't need to check for goldbach
            } else if (isGoldbach(i)) {
                System.out.println(i);//stop searching if its goldbach and print
                break;
            }
            i += 2;
        }

        timer.end();
    }

    private static boolean isPrime(int n){
        //instead of using function in toolbox, decided to create a new one so that the program doesn't have to check if prime from scratch for every number checked
        //instead, it references the arraylist
        //this can be implemented cause i am searching uniformly upwards
        int limit = (int) Math.sqrt(n) + 1; //standard way of decreasing search time for primes
        for (int prime : primes){
            if (prime > limit) return true;
            if (n % prime == 0) return false;
        }
        return true;
    }

    private static boolean isGoldbach(int n){
        for (int prime : primes){ //for every prime in the list, try and add each square
            if (prime > n) return true; //means cannot write as sum of prime and 2 * square
            int numberToSquare = 1;
            while (true){ //looking through different square values
                int total = prime + 2 * numberToSquare * numberToSquare;
                if (total == n) return false; //means can be written as sum
                if (total > n) break; //sum overshot n, go to next prime
                numberToSquare++;
            }
        }
        return true;
    }
}
