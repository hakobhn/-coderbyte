package com.example.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Using the JavaScript language, have the function SimpleMode(arr)
 * take the array of numbers stored in arr and return the number that
 * appears most frequently (the mode). For example: if arr contains
 * [10, 4, 5, 2, 4] the output should be 4. If there is more than one
 * mode return the one that appeared in the array first (ie. [5, 10, 10, 6, 5]
 * should return 5 because it appeared first). If there is no mode return -1. The array will not be empty.
 *
 */
class SimpleMode {

    public static int SimpleMode(int[] arr) {
        // code goes here
        Arrays.sort(arr);
        int counter = 1, maxCounter = 0, mResult = arr[0];

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.println("i="+i+" "+arr[i] +" == "+ arr[i - 1]);
            if (arr[i] == arr[i - 1]) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                mResult = arr[i];
            }
        }

        if (maxCounter == 1) {
            return -1;
        } else {
            return mResult;
        }
    }

    /**
     *
     * 5, 10, 10, 6, 5, 4, 7, 5
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(SimpleMode(inputArray));
    }
}