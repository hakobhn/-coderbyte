package com.example.easy;

import java.util.Scanner;

/**
 * Have the function ABCheck(str) take the str parameter being passed and return the string true if the characters a and b are
 * separated by exactly 3 places anywhere in the string at least once (ie. "lane borrowed" would result in true because there
 * is exactly three characters between a and b). Otherwise, return the string false.
 */
class ABCheck {

    public static boolean ABCheck(String str) {
        // code goes here
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (checkCondition(chars, i, 'a', 'b', 4)) {
                return true;
            }
            if (checkCondition(chars, i, 'b', 'a', 4)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkCondition(char[] chars, int index, char chr1, char chr2, int distance) {
        return chars[index] == chr1 && (index + 4) < chars.length && chars[index + 4] == chr2;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(ABCheck(s.nextLine()));
    }

}
