package com.example.hard;

import java.util.Scanner;


/**
 *
 * Challenge (hard)
 * Have the function MaximalSquare(strArr) take the strArr parameter being passed which will be a 2D matrix of 0 and 1's,
 * and determine the area of the largest square submatrix that contains all 1's. A square submatrix is one of equal width
 * and height, and your program should return the area of the largest submatrix that contains only 1's. For example: if
 * strArr is ["10100", "10111", "11111", "10010"] then this looks like the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * For the input above, you can see the bolded 1's create the largest square submatrix of size 2x2, so your program should
 * return the area which is 4. You can assume the input will not be empty.
 * Hard challenges are worth 15 points and you are not timed for them.
 * Sample Test Cases
 * Input:["0111", "1111", "1111", "1111"]
 * Output:9
 * Input:["0111", "1101", "0111"]
 * Output:1
 *
 *
 */
class MaximalSquare {

    public static int MaximalSquare(String[] strArr) {

        char[][] arr1 = new char[strArr.length][strArr[0].length()];

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[0].length(); j++) {

                arr1[i][j] = strArr[i].charAt(j);

            }
        }

        int x = arr1.length + 1;
        int y = arr1[0].length + 1;

        int[][] arr2 = new int[x][y];

        int max = 0;

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {

                if (arr1[i - 1][j - 1] == '1') {

                    arr2[i][j] = Math.min(arr2[i - 1][j - 1], Math.min(arr2[i - 1][j], arr2[i][j - 1])) + 1;

                    if (arr2[i][j] > max) {

                        max = arr2[i][j];
                    }
                }
            }
        }

        return max * max;
    }

    /**
     *
     * 10100,10111,11111,10010
     * 01111,11111,11111,11111
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(MaximalSquare(s.nextLine().split(",")));
    }
}
