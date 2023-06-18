package com.example.medium;

import java.util.Scanner;

/**
 *
 * Using the Java language, have the function NumberSearch(str) take the str parameter,
 * search for all the numbers in the string, add them together, then return that final number
 * divided by the total amount of letters in the string. For example: if str is "Hello6 9World 2, Nic8e D7ay!"
 * the output should be 2. First if you add up all the numbers, 6 + 9 + 2 + 8 + 7 you get 32. Then there are 17
 * letters in the string. 32 / 17 = 1.882, and the final answer should be rounded to the nearest whole number,
 * so the answer is 2. Only single digit numbers separated by spaces will be used throughout
 * the entire string (So this won't ever be the case: hello44444 world). Each string will also have at least one letter.
 *
 */
class NumberSearch {

    public static int NumberSearch(String str) {
        // code goes here
        double countLetter = 0;
        double sumTotal = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                countLetter++;
            }
            if (Character.isDigit(str.charAt(i)) == true) {
                sumTotal += Character.getNumericValue(str.charAt(i));

            }
        }
        result = (int) Math.round(sumTotal / countLetter);

        return result;
    }

    /**
     *
     * Hello6 9World 2, Nic8e D7ay!
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(NumberSearch(s.nextLine()));
    }

}