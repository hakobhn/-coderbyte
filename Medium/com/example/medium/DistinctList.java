package com.example.medium;

import java.util.Arrays;
import java.util.Scanner;

class DistinctList {

    public static int DistinctList(int[] arr) {
        Arrays.sort(arr);
        int counter = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print(DistinctList(inputArray));
    }
}