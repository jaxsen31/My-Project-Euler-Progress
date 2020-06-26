package ProjectEuler;

import Toolbox.Timer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these
values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly
two-thousand common English words, how many are triangle words?
 */
public class qn42_CodedTriangleNumbers {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();

//        for (int i = 1; i <= 60; i++){
//            if (isTriangleNumber(i)) System.out.println(i);
//        }

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jaxsen31\\Documents\\p042_words.txt"));
        int count = 0;
        String line;
        while ((line = reader.readLine()) != null){
            for (String word : line.replaceAll("\"", "").split(",")){
                char[] arr = word.toCharArray();
                int wordValue = 0;
                for (char n : arr){
                    wordValue += (n - 64);
                }
                if (isTriangleNumber(wordValue)) count++;
            }
        }

        System.out.println(count);


        timer.end();
    }

    private static boolean isTriangleNumber(int n){
        int test = n * 2;
        test = (int) Math.sqrt(test);
        return n == 0.5 * test * (test + 1);
    }
}
