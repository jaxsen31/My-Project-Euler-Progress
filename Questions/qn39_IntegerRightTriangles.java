package ProjectEuler;

import Toolbox.Timer;

import java.util.HashMap;
import java.util.Map;

/*
If p is the perimeter of a right angle triangle with integral length sides,
{a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class qn39_IntegerRightTriangles {
    public static void main(String[] args){
        Timer timer = new Timer();

        int sumLimit = 1000;
        System.out.println(pythagoreanTriplets(sumLimit));
        timer.end();
    }

    private static int pythagoreanTriplets(int sumLimit){
        HashMap<Integer, Integer> map = new HashMap<>();
        //map with the keys being the sum and the value is the number of times the sum can be written as a pythagorean triple
        for (int sum = 12; sum <= sumLimit; sum++){ //starting with 12 since 3 4 5 is smallest triple
            int a, b, c;
            for (c = sum / 3; c < sum / 2; c++){
                //c must be bigger than the rest so start at sum/3, cannot be more than the sum of the other 2 so stop at sum/2
                for (a = 1; a < c; a++){ //scrub through values of a and b
                    b = sum - a - c;
                    if (b >= c) continue; //c must be bigger than b
                    if (a * a + b * b == c * c){ //if is pythagorean triple
                        if (map.containsKey(sum)){
                            map.compute(sum, (k,v) -> v += 1); //if map already contains sum, increase value by 1
                        } else {
                            map.put(sum , 1); //if map doesn't contain sum, put sum into map
                        }
                    }
                }
            }
        }

        System.out.println(map); //just to show the map
        //one thing about the way i find triples is that each triple counts twice
        // 3,4,5 will count twice as 4,3,5 is counted as a different triple

        int maxRep = 0;
        int highestRep = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            //go through all the entries in the map to find the one with the most repetitions
            if (entry.getValue() > maxRep){
                maxRep = entry.getValue();
                highestRep = entry.getKey();
            }
        }
        return highestRep;
    }
}
