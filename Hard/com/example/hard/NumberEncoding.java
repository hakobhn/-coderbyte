package com.example.hard;

import java.util.Scanner;


/**
 *
 * Using the Java language, have the function NumberEncoding(str)
 * take the str parameter and encode the message according to the following rule:
 * encode every letter into its corresponding numbered position in the alphabet.
 * Symbols and spaces will also be used in the input. For example: if str is "af5c a#!"
 * then your program should return 1653 1#!.
 *
 */
class NumberEncoding {

    public static String StringChallenge(String str) {
        // code goes here
        String result = "";
        str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result += str.charAt(i) - 97 + 1;
            } else {
                result += str.charAt(i);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

}