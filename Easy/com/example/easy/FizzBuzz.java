package com.example.easy;

import java.util.Scanner;

class FizzBuzz {

    public static String FizzBuzz(int num) {
        // Abdullah Tas

        String result = "";
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result += "com.example.FizzBuzz";
            } else if (i % 3 == 0) {
                result += "Fizz";
            } else if (i % 5 == 0) {
                result += "Buzz";
            } else {
                result += String.valueOf(i);
            }
            result += " ";
        }
        return result;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FizzBuzz(s.nextInt()));
    }

}
