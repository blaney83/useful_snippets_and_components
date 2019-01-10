package io.github.blaney83;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter count: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] myArray = buildArray(count);
        reverseArray(myArray);
    }
    public static int[] buildArray(int number){
        System.out.println("Enter " + number + " integers to start: ");
        int[] builtArr = new int[number];
        for(int i = 0; i < number; i ++){
            builtArr[i] = scanner.nextInt();
        }
        return builtArr;
    }

    public static void reverseArray (int[] array){
        int[] reversedArray = new int[array.length];
        int revInd = 0;
        for(int i = array.length ; i > 0; i --){
            reversedArray[revInd] = array[i-1];
            revInd ++;
        }
        System.out.println(Arrays.toString(reversedArray));
    }

    //alternate
    // public static void reverseArray (int[] array){
    //     int halfInd = array.length / 2;
    //     for(int i = 0 ; i < halfInd; i ++){
    //         int val = array[i];
    //         array[i] = array[(array.length - 1) - i];
    //         array[(array.length - 1) - i] = val;
    //     }
    //     System.out.println(Arrays.toString(array));
    // }
}
