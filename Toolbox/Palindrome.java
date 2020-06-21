package Toolbox;

public class Palindrome {
    public static boolean isPalindromic(String n){
        char[] arr = n.toCharArray();
        int middleIndex = n.length() / 2;
        for (int i = 0; i < middleIndex; i++){
            char test = arr[i];
            char comparison = arr[n.length()-1-i];
            if (test != comparison){
                return false;
            }
        }
        return true;
    }
}
