package Toolbox;

import java.math.BigInteger;

public class PnC {
    public static long factorial(int n){
        long total = 1;
        for (int i = 2; i <= n; i++){
            total *= i;
        }
        return total;
    }

    public static long compute(int n, int r){
        BigInteger total = BigInteger.ONE;
        for (int i = Math.max(r, n-r)+1; i <= n; i++){
            total = total.multiply(BigInteger.valueOf(i));
        }
        for (int i = 2; i <= Math.min(r, n-r); i++){
            total = total.divide(BigInteger.valueOf(i));
        }

        return total.longValue();
    }
}
