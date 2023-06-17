package com.example.medium;

import java.util.Scanner;

class Division {

    public static int MathChallenge(int n1, int n2) {
        while (n1 != n2) {
            if (n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }

        return n1;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MathChallenge(s.nextInt(), s.nextInt()));
    }

}