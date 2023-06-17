package com.example.easy;

import java.util.Scanner;

class SimpleAdding {
    public static int SimpleAdding(int num) {
        // code goes here
        num = num * (num + 1) / 2;
        return num;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SimpleAdding(s.nextInt()));
    }
}