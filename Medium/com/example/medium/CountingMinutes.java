package com.example.medium;

import java.util.Scanner;

/**
 *
 * *  Counting Minutes I                                                                  *
 * *  Using the Java language, have the function CountingMinutesI(str) take the           *
 * *  str parameter being passed which will be two times (each properly formatted with    *
 * *  a colon and am or pm) separated by a hyphen and return the total number of minutes  *
 * *  between the two times. The time will be in a 12 hour clock format. For example:     *
 * *  if str is 9:00am-10:00am then the output should be 60. If str is 1:00pm-11:00am     *
 * *  the output should be 1320.
 *
 */
class CountingMinutes {

    public static int CountingMinutes(String str) {
        String[] time = str.split("-");

        String[] firstTime = time[0].split(":");
        int firstHour = Integer.parseInt(firstTime[0]);
        int firstMin = extractMin(firstTime[1]);
        // am or pm
        String firstPeriod = extractPeriod(firstTime[1]);

        String[] secondTime = time[1].split(":");
        int secondHour = Integer.parseInt(secondTime[0]);
        int secondMin = extractMin(secondTime[1]);
        // am or pm
        String secondPeriod = extractPeriod(secondTime[1]);

        if (!firstPeriod.equals(secondPeriod)) {
            return (12 - firstHour) * 60 + (60 - firstMin) + (secondHour - 1) * 60 + secondMin;
        } else {
            if ((firstHour > secondHour) || ((firstHour == secondHour) && (firstMin > secondMin))) {
                return (24 - firstHour) * 60 + (60 - firstMin) + (secondHour - 1) * 60 + secondMin;
            } else {
                return (secondHour - (firstHour + 1)) * 60 + (60 - firstMin) + secondMin;
            }
        }
    }

    public static String extractPeriod(String time) {
        String period = "";
        period = time.substring(2);
        return period;
    }

    public static int extractMin(String time) {
        String min = "";
        min = time.substring(0, 2);
        return Integer.parseInt(min);
    }

    /**
     *
     * 9:00am-10:00am
     * 11:00am-1:00pm
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(CountingMinutes(s.nextLine()));
    }
}