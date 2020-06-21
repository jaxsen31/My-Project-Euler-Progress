package ProjectEuler;

import Toolbox.Timer;

/*
The sum of the squares of the first ten natural numbers is,

1^2+2^2+...+10^2=385
The square of the sum of the first ten natural numbers is,

(1+2+...+10)^2=552=3025
Hence the difference between the sum of the squares of the first ten natural numbers
and the square of the sum is 3025−385=2640.

Find the difference between the sum of the squares of the first one hundred natural
numbers and the square of the sum.
 */
public class qn06_SumSquareDifference {
    public static void main(String[] args){
        Timer timer = new Timer();

        int limit = 100;
        long sumSquare = sumSquare(limit); //multiply every number including 100
        long squareSum = squareSum(limit); //use formula to get sum then square the value
        System.out.println(squareSum - sumSquare);
        timer.end();
    }

    private static long sumSquare(int n){
        long answer = 0;
        for (int i = 1; i <= n; i++){
            answer += i*i;
        }
        return answer;
    }

    private static long squareSum(int n){
        long sum = n * (n+1) / 2;
        return sum * sum;
    }
}
