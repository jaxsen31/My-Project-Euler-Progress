package Toolbox;

import java.io.*;
import java.util.ArrayList;

//C:\Users\jaxsen31\Documents\Hello.txt
public class SampleFIS {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();
        //get file path name from console <<note if copy from windows, need to remove ""

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //reader to read from designated file path

        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            list.add(line);
            //reader reads each line and adds the string to list
        }
        reader.close();

        for (String n : list){
            System.out.println(n);
        }
        //print list
    }
}
