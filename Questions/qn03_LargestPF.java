package ProjectEuler;

import Toolbox.PrimeFactors;
import Toolbox.Timer;

import java.util.ArrayList;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */
public class qn03_LargestPF {
    public static void main(String[] args) {
        Timer timer = new Timer();

        long test = 600851475143L;
        ArrayList<Long> PFs = PrimeFactors.primeFactors(test); //generate list of PFs for test
        System.out.println(PFs.get(PFs.size()-1)); //get the largest PF

        timer.end();
    }
}
