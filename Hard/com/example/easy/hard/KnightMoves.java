package com.example.easy.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * given an 8 x 8 chessboard, a selected starting square, how many legal moves knight can do
 */
public class KnightMoves {

    public static int KnightMoves(String str) {
        int[][] moves_table = new int[][]{{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};

        int[] knight_position = new int[2];

        //knight_position = redundant(str); //The digit indexes are always same.

        knight_position[0] = Character.digit(str.charAt(1), 10);
        knight_position[1] = Character.digit(str.charAt(3), 10);

        int count = 0;
        int x, y;

        for (int[] move : moves_table) {
            x = knight_position[0] + move[0];
            y = knight_position[1] + move[1];

            if (0 < x && x <= 8 && 0 < y && y <= 8) //first square of the board is 1
                count++;
        }
        return count;
    }

    static int[] redundant(String str) {
        int[] knight_position2 = new int[2];

        int[] index_of_digits = new int[2];
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                index_of_digits[j] = i;
                knight_position2[j] = Character.digit(str.charAt(i), 10);
                j++;
            }
        }
        System.out.println(Arrays.toString(index_of_digits));
        return knight_position2;
    }

    /**
     *
     * (2 8)
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(KnightMoves(s.nextLine()));
    }

}
