package Toolbox;

import java.util.ArrayList;

public class ArrayLists {
    public static ArrayList<Integer> multiplyArrayList(ArrayList<Integer> n, int a){
        for (int i = 0; i < n.size(); i++){
            n.set(i, n.get(i) * a);
        }
        for (int i = n.size()-1; i > 0; i--){
            int value = n.get(i);
            if (value > 9){
                n.set(i, value % 10);
                n.set(i-1, n.get(i-1) + value/10);
            }
        }
        while (n.get(0) > 9){
            int value = n.get(0);
            n.set(0, value % 10);
            n.add(0, value / 10);
        }

        return n;
    }

    public static ArrayList<Integer> add2ArrayLists(ArrayList<Integer> toBeReturned, ArrayList<Integer> toAddOn){
        //assuming both are the same length
        if (toBeReturned.size() == toAddOn.size()){
            for (int i = 0; i < toBeReturned.size(); i++){
                toBeReturned.set(i, toBeReturned.get(i) + toAddOn.get(i));
            }

            for (int i = toBeReturned.size()-1; i > 0; i--){
                int value = toBeReturned.get(i);
                if (value > 9){
                    toBeReturned.set(i, value % 10);
                    toBeReturned.set(i-1, toBeReturned.get(i-1) + value/10);
                }
            }
            while (toBeReturned.get(0) > 9){
                int value = toBeReturned.get(0);
                toBeReturned.set(0, value % 10);
                toBeReturned.add(0, value / 10);
            }
            return toBeReturned;
        } else {
            //if they're different length
            ArrayList<Integer> longer = toBeReturned.size() > toAddOn.size() ? toBeReturned : toAddOn;
            ArrayList<Integer> shorter = toBeReturned.size() < toAddOn.size() ? toBeReturned : toAddOn;
            int offset = longer.size() - shorter.size();
            for (int i = 0; i < shorter.size(); i++){
                longer.set(i + offset, shorter.get(i) + longer.get(i + offset));
            }

            for (int i = longer.size()-1; i > 0; i--){
                int value = longer.get(i);
                if (value > 9){
                    longer.set(i, value % 10);
                    longer.set(i-1, longer.get(i-1) + value/10);
                }
            }
            while (longer.get(0) > 9){
                int value = longer.get(0);
                longer.set(0, value % 10);
                longer.add(0, value / 10);
            }
            return longer;
        }
    }
//    public static ArrayList<Long> multiplyArrayList(ArrayList<Long> n, int a){
//        for (int i = 0; i < n.size(); i++){
//            n.set(i, n.get(i) * a);
//        }
//        for (int i = n.size()-1; i > 0; i--){
//            long value = n.get(i);
//            if (value > 9){
//                n.set(i, value % 10);
//                n.set(i-1, n.get(i-1) + value/10);
//            }
//        }
//        while (n.get(0) > 9){
//            long value = n.get(0);
//            n.set(0, value % 10);
//            n.add(0, value / 10);
//        }
//
//        return n;
//    }
}
