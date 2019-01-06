package com.blaney83;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = 5;
        System.out.println("Enter " + length + " numbers: ");
        int[] initArr = buildArray(length);
        printArray(sortArray(initArr));
    }

    public static int[] buildArray(int number) {
        int[] unsortedArr = new int[number];
        for (int i = 0; i < number; i++) {
            unsortedArr[i] = scanner.nextInt();
        }
        printArray(unsortedArr);
        return unsortedArr;
    }

    public static void printArray(int[] array) {
        String output = "";
        for (int i = 0; i < array.length; i++) {
            output = output +" " + array[i];
        }
        System.out.println(output);
    }

    public static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int count = 0;
            for (int n = 0; n < array.length - i - 1; n++) {
                if (array[n] > array[n + 1]) {
                    int hold = array[n];
                    array[n] = array[n + 1];
                    array[n + 1] = hold;
                    count = 1;
                }
            }
            if (count == 0) {
                break;
            }
        }
        return array;
    }
}
