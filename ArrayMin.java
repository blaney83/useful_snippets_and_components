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
	    findMin(myArray);
    }

    public static int[] buildArray(int number){
        System.out.println("Enter " + number + " integers to start: ");
        int[] builtArr = new int[number];
        for(int i = 0; i < number; i ++){
            builtArr[i] = scanner.nextInt();
        }
        return builtArr;
    }

    public static void findMin (int[] array){
        System.out.println("Your numbers " + Arrays.toString(array));;
        int minVal = Integer.MAX_VALUE;
        for(int element: array){
            if(element < minVal){
                minVal = element;
            }
        }
        System.out.println("The min val is: " + minVal);
    }
}
