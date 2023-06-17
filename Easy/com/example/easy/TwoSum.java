package com.example.easy;

import java.util.Arrays;
import java.util.Scanner;

class TwoSum {

    public static String TwoSum(int[] arr) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == arr[0]) {
                    if (output.length() > 0) {
                        output.append(" ");
                    }
                    output.append(arr[i]).append(",").append(arr[j]);
                }
            }
        }
        return output.length() == 0 ? "-1" : output.toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print(TwoSum(inputArray));
    }
}
