package ProjectEuler;

import Toolbox.Timer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */
public class qn22_NamesScores {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();

        String fileName = "C:\\Users\\jaxsen31\\Documents\\p022_names.txt"; //name of file
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); //reader to read from file
        StringBuilder build = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            build.append(line);
        }
        //taking all the data from the file and putting it into a stringbuilder
        String[] words = build.toString().replaceAll("\"", "").split(",");
        //remove all ", split into individual words
        Arrays.sort(words);
        //sort names
        System.out.println(words[937]); //check if the 978th is colin

        long total = 0;
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            long wordValue = 0;
            char[] letters = word.toCharArray(); //split into individual letters
            for (char letter : letters){
                wordValue += (letter - 64); //for each letter, add its ascii value, minus 64 since A is 65
            }
            wordValue *= (i + 1); //need to multiply word value by its position
            total += wordValue; //add to total
        }

        System.out.println(total);

        timer.end();
    }
}
