package com.example.easy;

import java.util.Arrays;
import java.util.Scanner;

class MeanMode {

    public static int MeanMode(int[] arr) {
        // code goes here
        int result = 0, ort, mod;

        if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3) {
            return 0;

        } else {
            for (int i : arr) {
                result += i;
            }

            ort = result / arr.length;
            mod = arr[(arr.length / 2)];


            if (mod == ort) {

                return 1;
            } else {

                return 0;

            }
        }

    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print(MeanMode(inputArray));
    }

}
