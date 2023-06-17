package com.example.medium;

import java.util.Arrays;
import java.util.Scanner;

class Consecutive {

    public static int Consecutive(int[] arr) {
        // code goes here
        Arrays.sort(arr);

        int amount = 0;
        for (int i = 1; i < arr.length; i++) {
            amount += Math.abs(arr[i] - arr[i - 1]) - 1;
        }
        return amount;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print(Consecutive(inputArray));
    }

}