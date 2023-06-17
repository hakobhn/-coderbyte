package com.example.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * given an 8 x 8 chessboard, a selected starting square, and a selected ending square, what is the minimum number
 * of legal moves required to get a knight piece from the starting square to the ending square
 */
public class KnightJumps {

    private static int[][] MOVES = new int[][]{{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};

    public static int KnightJumps(String[] strArr) {
        int[] currentPosition = Arrays.stream(strArr[0].split(",")).mapToInt(Integer::parseInt).toArray();
        int[] finalPosition = Arrays.stream(strArr[1].split(",")).mapToInt(Integer::parseInt).toArray();


        int count = 1;
        int[][] board = new int[8][8];

        board[currentPosition[0]-1][currentPosition[1]-1] = 1;
//        board[finalPosition[0]-1][finalPosition[1]-1] = -1;

        fill(board, count, finalPosition);

        for (int i =0; i < 8; i++) {
            for (int j =0; j < 8; j++) {
                System.out.print(String.format("%-" + 3 + "s", board[i][j]));
            }
            System.out.println();
        }

        return board[finalPosition[0]-1][finalPosition[1]-1];
    }

    private static boolean isSameCords(int[] currentPosition, int[] finalPosition ) {
        if (currentPosition[0] == finalPosition[0] && currentPosition[1] == finalPosition[1]) {
            return true;
        }
        return false;
    }

    private static void fill(int[][] board, int count, int[] finalPosition) {
        for (int i =0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == count) {
                    for (int[] move : MOVES) {
                        int x = i+1 + move[0];
                        int y = j+1 + move[1];

                        if (0 < x && x <= 8 && 0 < y && y <= 8 && board[x - 1][y - 1] == 0) {
                            board[x - 1][y - 1] = count + 1;
                            if (isSameCords(new int[]{x, y}, finalPosition)) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        fill(board, ++count, finalPosition);
    }

    /**
     *
     * (2,8)(2,4) -3
     * (2,8)(6,6) - 3
     * (1,1)(2,4) - 4
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        input = input.substring(1, input.length()-1);
        System.out.println(KnightJumps(input.split("\\)\\(")));
    }

}
