package com.example.medium;

import java.util.Scanner;

/**
 * Using the Java language, have the function BinaryConverter(str)
 * return the decimal form of the binary value. For example:
 * if 101 is passed return 5, or if 1000 is passed return 8. */
class BinaryConverter {

    public static int MathChallenge(String str) {
        // Abdullah Tas

        int decimal = Integer.valueOf(str, 2);

        return decimal;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(MathChallenge(s.nextLine()));
    }

}