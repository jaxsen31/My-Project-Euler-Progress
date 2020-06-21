package Toolbox;

import java.util.Scanner;

public class PerfectSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        isPerfectSquare(test);
    }

    public static void isPerfectSquare(int n) {
        boolean a = false;
        for (int i = 1; i < n; i++) {
            if (i * i == n) {
                a = true;
                break;
            }
        }
        if (a) {
            System.out.printf("%d is a perfect square.", n);
        } else {
            System.out.printf("%d is not a perfect square.", n);
        }
    }
}
