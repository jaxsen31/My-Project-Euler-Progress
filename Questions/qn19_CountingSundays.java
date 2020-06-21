package ProjectEuler;

import Toolbox.Timer;

import java.util.ArrayList;

/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class qn19_CountingSundays {
    static ArrayList<Integer> leapYear = new ArrayList<>();
    static ArrayList<Integer> nonLeapYear = new ArrayList<>();
    //list of indexes for the first of the month

    static {
        int[] leapYear1 = {1, 32, 61, 92, 122, 153, 183, 214, 245, 275, 306, 336}; //filling the lists
        int[] nonLeap1 = {1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        for (int i : leapYear1){
            leapYear.add(i);
        }
        for (int i : nonLeap1){
            nonLeapYear.add(i);
        }
    }
    public static void main(String[] args){
        Timer timer = new Timer();

        int count = 0; //number of sundays that fall on the first of the month
        int dayCount = 1; //running count for what day it is -> monday is 1, sunday is 7 14 21 28...
        dayCount += 365; //account for the difference in info given -> monday on 1/1/1900 but counting starts in 1901
        for (int year = 1901; year < 2001; year++) { //loop through each year
            if (year % 4 == 0 && year % 400 != 0) {
                //leap year
                for (int date = 1; date <= 366; date++){
                    //loop through 366 days
                    if (leapYear.contains(date) && dayCount % 7 == 0){
                        //first condition means its first of the month, second means its a sunday
                        count++;
                        System.out.println(date + " " + year);
                    }
                    dayCount++;
                }
            } else {
                //non-leap year
                for (int date = 1; date <= 365; date++){
                    //loop through 365 days
                    if (nonLeapYear.contains(date) && dayCount % 7 == 0){
                        //first condition means its first of the month, second means its a sunday
                        count++;
                        System.out.println(date + " " + year);
                    }
                    dayCount++;
                }
            }
        }

        System.out.println(count);
        timer.end();
    }
}
