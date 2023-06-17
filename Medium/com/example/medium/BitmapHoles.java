package com.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * Using the Python language, have the function BitmapHoles(strArr)
 * take the array of strings stored in strArr, which will be a 2D matrix
 * of 0 and 1's, and determine how many holes, or contiguous regions of 0's,
 * exist in the matrix. A contiguous region is one where there is a
 * connected group of 0's going in one or more of four directions: up,
 * down, left, or right. For example: if strArr is
 * ["10111", "10101", "11101", "11111"], then this looks like the following matrix:
 * 1 0 1 1 1
 * 1 0 1 0 1
 * 1 1 1 0 1
 * 1 1 1 1 1
 * For the input above, your program should return 2 because
 * there are two separate contiguous regions of 0's, which create
 * "holes" in the matrix. You can assume the input will not be empty.
 * Input:"01111", "01101", "00011", "11110"
 * Output:3
 * Input:"1011", "0010"
 * Output:2
 *
 */
class BitmapHoles {
    public static int BitmapHolesOld(String[] strArr) {
        ArrayList<ArrayList<Integer>> index = new ArrayList<>();
        ArrayList<ArrayList<String>> mat = new ArrayList<>();
        int holes = 0;
        boolean checker;

        for (int i = 0; i < strArr.length; i++) {
            mat.add(new ArrayList<>(Arrays.asList(strArr[i].split(""))));
            for (int j = 0; j < strArr[i].length(); j++) {
                if (mat.get(i).get(j).equals("0")) {
                    index.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        for (int c = 0; c < index.size(); c++) {
            checker = false;
            for (int k = c + 1; k < index.size(); k++) {
                if (index.get(k).get(0) == index.get(c).get(0) + 1 &&
                        index.get(k).get(1) == index.get(c).get(1) ||
                        index.get(k).get(0) == index.get(c).get(0) &&
                                index.get(k).get(1) == index.get(c).get(1) + 1)
                    checker = true;
            }
            if (checker == false) holes++;
        }
        return holes;
    }

    public static int BitmapHoles(String[] strArr) {
        int[][] bitMap = new int[strArr.length][strArr[0].length()];

        for (int i = 0; i < strArr.length; i++) {
            String line = strArr[i].trim();
            for (int j = 0; j < line.length(); j++) {
                bitMap[i][j] = Integer.parseInt(""+line.charAt(j));
            }
        }

        List<Cell> holes = new ArrayList<>();

        for (int i = 0; i < bitMap.length; i++) {
            for (int j = 0; j < bitMap[0].length; j++) {
                if (bitMap[i][j] == 0) {
                    Cell current = new Cell(bitMap,i, j);
                    boolean isConnected = false;
                    for (Cell hole : holes) {
                        if (current.connectedWith(hole)) {
                            current.setConnected(true);
                        }
                    }

                    holes.add(current);
                }
            }
        }

        return holes.stream().filter(Predicate.not(Cell::isConnected)).collect(Collectors.toList()).size();
    }

    static class Cell {
        private int[][] bitMap;
        private int i;
        private int j;

        private boolean isConnected = false;

        public Cell(int[][] bitMap,  int i, int j) {
            this.bitMap = bitMap;
            this.i = i;
            this.j = j;
        }

        public boolean connectedWith(Cell c) {
            return
                    ( (c.getI()>0 && c.getI()-1==i && c.getJ() == j ) || (c.getJ()>0 && c.getJ()-1==j && c.getI() == i )) ||
                    ( (c.getI()<bitMap.length-1 && c.getI()+1==i && c.getJ() == j) ||
                            (c.getJ()<bitMap[0].length-1 && c.getJ()+1==j && c.getI() == i) );
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public boolean isConnected() {
            return isConnected;
        }

        public void setConnected(boolean connected) {
            isConnected = connected;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    i +
                    ", " + j +
                    "," + isConnected +
                    '}';
        }
    }

    /**
     * 10111, 10101, 11101, 11111
     * 101111, 100011, 111011, 111110
     *
     * 10111
     * 10001
     * 11101
     * 11111
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] inputArray = input.split(",");
        System.out.println(BitmapHoles(inputArray));
    }
}