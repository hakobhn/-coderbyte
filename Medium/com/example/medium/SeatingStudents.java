package com.example.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * Have the function SeatingStudents(arr) read the array of integers stored in arr which will be
 * in the following format: [K, r1, r2, r3, ...] where K represents the number of desks in a classroom,
 * and the rest of the integers in the array will be in sorted order and will represent the desks
 * that are already occupied. All of occupiedDesks.indexOf(i) != -1 desks will be arranged in 2 columns,
 * where desk #1 is at the top left, desk #2 is at the top right, desk #3 is below #1, desk #4 is below
 * #2, etc. Your program should return the number of ways 2 students can be seated next to each other.
 * This means 1 student is on the left and 1 student on the right, or 1 student is directly above or below the other student.
 *
 *  Desk 1  Desk 2
 *  Desk 2  Desk 4
 *  Desk 5  Desk 6
 *  ...
 *  Desk n-1  Desk n
 *
 *
 */
public class SeatingStudents {

    public static int SeatingStudents(int[] arr) {
        final int totalDesks = arr[0];
        final Set<Integer> occupiedDesks = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            occupiedDesks.add(arr[i]);
        }

        int count = 0;
        for (int currentDesk = 1; currentDesk < totalDesks; currentDesk++) {
            if (isOccupied(currentDesk, occupiedDesks, totalDesks)) {
                continue;
            }
            if (currentDesk % 2 != 0) {
                final int sideDesk = currentDesk + 1;
                if (!isOccupied(sideDesk, occupiedDesks, totalDesks)) {
                    count++;
                }
            }
            final int belowDesk = currentDesk + 2;
            if (!isOccupied(belowDesk, occupiedDesks, totalDesks)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isOccupied(final int desk, final Set<Integer> occupiedDesks, final int totalDesks) {
        return desk > totalDesks || occupiedDesks.contains(desk);
    }


    /**
     *
     * 12, 2, 6, 7, 11
     * 12, 2, 3, 6, 7, 10, 11
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(SeatingStudents(inputArray));
    }
}
