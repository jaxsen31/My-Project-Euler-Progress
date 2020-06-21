package ProjectEuler;

import Toolbox.ArrayLists;
import Toolbox.Timer;

import java.util.ArrayList;

/*
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class qn25_1000DigitFibonacciNumber {

    public static void main(String[] args){
        Timer timer = new Timer();

        ArrayList<Integer> f0 = new ArrayList<>();
        ArrayList<Integer> f1 = new ArrayList<>();
        f0.add(0);
        f1.add(1);
        //these 2 arraylists will hold the digits for the 2 previous fibonacci numbers

        int limit = 1000;
        int index = 2; //starts at 2 cause it immediately adds 0 + 1
        ArrayList<Integer> result;
        while (true){
            ArrayList<Integer> placeholder = (ArrayList<Integer>) f1.clone(); //have to clone as f1 gets updated in the next line
            result = ArrayLists.add2ArrayLists(f1, f0); //adding the 2 arraylists
            if (result.size() == limit){ //if the length is more than 1000
                break;
            }
            f0 = placeholder; //reassign values
            f1 = result;
            index++;
        }
        System.out.println(index);
        timer.end();
    }
}
