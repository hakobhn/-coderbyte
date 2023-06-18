package com.example.medium;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * // Have the function EightQueens(strArr) read strArr which will be an array
 * // consisting of the locations of eight Queens on a standard 8x8 chess board
 * // with no other pieces on the board. The structure of strArr will be the
 * // following: ["(x,y)", "(x,y)", ...] where (x,y) represents the position of the
 * // current queen on the chessboard (x and y will both range from 1 to 8 where
 * // 1,1 is the bottom-left of the chessboard and 8,8 is the top-right). Your
 * // program should determine if all of the queens are placed in such a way where
 * // none of them are attacking each other. If this is true for the given input,
 * // return the string "true" otherwise return the first queen in the list that is
 * // attacking another piece in the same format it was provided.
 * //
 * // For example: if strArr is ["(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)",
 * // "(1,6)", "(7,7)", "(5,8)"] then your program should return the string true.
 * // The corresponding chessboard of queens for this input is below (taken from
 * // Wikipedia).
 *
 */
public class EightQueens {

    public static String EightQueens(String[] strArr) {

        int[][] board = new int[8][8];

//        markAttacks(board, 4,4);
//        for (int i =0; i < 8; i++) {
//            for (int j =0; j < 8; j++) {
//                System.out.print(String.format("%-" + 3 + "s", board[i][j]));
//            }
//            System.out.println();
//        }

        for (String positionStr : strArr) {
            int[] position = Arrays.stream(positionStr.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            int x = position[0];
            int y = position[1];

            if (board[x-1][y-1] != 0) {
                return "false";
            }
            board[x-1][y-1] = 1;
            markAttacks(board, x,y);
        }

        return "true";
    }

    private static void markAttacks(int[][] board, int x, int y) {
        for (int i = 0; i < 8; i++) {
            board[x-1][i] = 1;
            board[i][y-1] = 1;

            if (x-1+i >= 0 && x-1+i<8 && y-1+i >= 0 && y-1+i<8) {
                board[x - 1 + i][y - 1 + i] = 1;
            }
            if (x-1-i >= 0 && x-1-i<8 && y-1-i >= 0 && y-1-i<8) {
                board[x - 1 - i][y - 1 - i] = 1;
            }
            if (x-1+i >= 0 && x-1+i<8 && y-1-i >= 0 && y-1-i<8) {
                board[x - 1 + i][y - 1 - i] = 1;
            }
            if (x-1-i >= 0 && x-1-i<8 && y-1+i >= 0 && y-1+i<8) {
                board[x - 1 - i][y - 1 + i] = 1;
            }
        }
    }


    /**
     *
     * [(2,1), (4,2), (6,3), (8,4), (3,5), (1,6), (7,7), (5,8)] - true
     * [(2,1), (2,2), (6,3), (8,4), (3,5), (1,5), (7,7), (5,8)] - false
     *
     * @param args
     */
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        System.out.println(EightQueens(line.substring(2, line.length()-2).split("\\), \\(")));
    }
}
