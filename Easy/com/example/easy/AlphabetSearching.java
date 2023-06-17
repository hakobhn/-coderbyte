package com.example.easy;

import java.util.Scanner;

/**
 * Program to Check Whether a string contains all English Alphabet 26 letters, with correct order, or Not
 */
class AlphabetSearching {

    public static String StringChallenge(String str) {
        // code goes here
        boolean lever = true;
        //char[] charStr = str.toCharArray();


        for (char letter = 'a'; letter <= 'z'; letter++) {
            String strLetter = String.valueOf(letter);
            if (str.contains(strLetter)) {
                lever = true;
            } else {
                lever = false;
            }

        }

        String output = Boolean.toString(lever);
        return output;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(StringChallenge(s.nextLine()));
    }
}