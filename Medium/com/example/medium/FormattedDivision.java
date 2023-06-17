package com.example.medium;

import java.util.Scanner;

;
;

class FormattedDivision {

    public static String FormattedDivision(int num1, int num2) {
        // code goes here
        double division = num1 * 1.00 / num2;
        return String.format("%,.4f", division);
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FormattedDivision(s.nextInt(), s.nextInt()));
    }
}