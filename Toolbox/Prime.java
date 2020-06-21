package Toolbox;

import java.util.ArrayList;
import java.util.HashSet;

public class Prime {

    public static long nthPrime(int n){
        long num = 2, count = 1, i;
        while (count < n){
            num++;
            for (i = 2; i <= num; i++){
                if (num % i == 0){
                    break;
                }
            }
            if (i == num){
                count++;
            }
        }
        return num;
    }

    public static ArrayList<Integer> primesUpToN(int n){
        boolean[] prime = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            prime[i] = true;
        }
        //all indexes is true, later if not prime then set to false

        for (int p = 2; p*p <=n; p++){
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if (prime[i]){
                primes.add(i);
            }
        }
        primes.remove(0); //removing the number 1 from the list of primes
        return primes;
    }

    public static ArrayList<Long> primesUpToN(long n){
        boolean[] prime = new boolean[(int) (n+1)];
        for(int i = 0; i < n; i++) {
            prime[i] = true;
        }
        //all indexes is true, later if not prime then set to false

        for (int p = 2; p*p <=n; p++){
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        ArrayList<Long> primes = new ArrayList<>();
        for(long i = 1; i <= n; i++){
            if (prime[(int) i]){
                primes.add(i);
            }
        }
        primes.remove(0); //removing the number 1 from the list of primes
        return primes;
    }

    public static boolean checkPrime(int n){
        if (n == 1) return false;
        if (n == 2) return true;

        int limit = (int)Math.sqrt(n) + 1;
        for (int i = 2; i <= limit; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrime(long n){
        if (n == 1){
            return false;
        }
        long limit = (long)Math.sqrt(n) + 1;
        for (long i = 2; i <= limit; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int sumNPrimes(int n){
        long nthPrime = nthPrime(n);
        ArrayList<Long> listOfPrimes = primesUpToN(nthPrime);
        int sum = 0;
        for (long i : listOfPrimes){
            sum += i;
        }
        return sum;
    }

    public static boolean relativelyPrime(int i, int n){
        HashSet<Integer> iPFs = pck1.PrimeFactors.uniquePrimeFactors(i);
        HashSet<Long> nPFs = PrimeFactors.uniquePrimeFactors(n);
        if (iPFs.size() < nPFs.size()){
            for (int a : iPFs){
                if (nPFs.contains(a)){
                    return false;
                }
            }
        } else {
            for (Long a : nPFs){
                if (iPFs.contains(a)){
                    return false;
                }
            }
        }
        return true;
    }
}
