package Toolbox;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapAlg {
    public HeapAlg(int[] arrayDigits) {
        this.arrayDigits = arrayDigits;
        heapAlg(arrayDigits, arrayDigits.length);
    }

    public ArrayList<String> list = new ArrayList<>();
    int[] arrayDigits;

    //Generating permutation using Heap Algorithm and immediately prints
    public void heapAlg(int[] a, int size){
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            StringBuilder build = new StringBuilder();
            for (int i : a){
                build.append(i);
            }
            list.add(build.toString());
        }
        for (int i = 0; i < size; i++){
            heapAlg(a, size - 1);

            // if size is odd, swap first and last element
            int temp;
            if (size % 2 == 1){
                temp = a[0];
                a[0] = a[size-1];
            }
            // If size is even, swap ith and last element
            else {
                temp = a[i];
                a[i] = a[size-1];
            }
            a[size-1] = temp;
        }
    }

//    public static void main(String[] args){
//        int[] arr = {1,2,3};
//        HeapAlg alg = new HeapAlg(arr);
//        alg.heapAlg(arr, arr.length);
//    }
}
