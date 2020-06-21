package Toolbox;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimeFactors {

    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            if (n % i == 0){
                factors.add(i);
                n /= i;
                i--;
            }
        }
        return factors;
    }

    public static ArrayList<Long> primeFactors(long n){
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 2; i <= n; i++){
            if (n % i == 0){
                factors.add(i);
                n /= i;
                i--;
            }
        }
        return factors;
    }

    public static HashSet<Long> uniquePrimeFactors(long n){
        HashSet<Long> factors = new HashSet<>();
        for (long i = 2; i <= n; i++){
            if (n % i == 0){
                factors.add(i);
                n /= i;
                i--;
            }
        }
        return factors;
    }
}
