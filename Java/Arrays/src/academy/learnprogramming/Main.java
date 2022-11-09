package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

//        int[] myIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(myIntArray[5]); // get element
//        myIntArray[5] = 50; // set element
//        System.out.println(myIntArray[5]); // get element

//        int[] myIntArray = new int[10];
//        for (int i =0; i<myIntArray.length; i++) {
//            myIntArray[i] = i * 10;
//        }
//        printArray(myIntArray);
//
//        double[] myDoubleArray = new double[10];

//        int[] myIntegers = getIntegers(5);
//        printArray(myIntegers);
//        System.out.println("The average is "+getAverage(myIntegers));

        // Challenge time Sort Array
        int[] myIntegers = getIntegers(5);
//        int[] sorted  = sortIntegers(myIntegers);
        int[] sorted = bubbleSortIntegers(myIntegers);
        printArray(sorted);

    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter "+number+" integer values.\r");
        int[] values = new int[number];
        for (int i = 0; i<values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array) {
        int sum=0;
        for (int i=0; i<array.length; i++) {
            sum+=array[i];
        }
        return (double) sum/array.length;
    }

    public static void printArray(int[] array) {
        for (int i =0; i<array.length; i++) {
            System.out.println("Element "+i+", value is "+array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
//        int[] sortedArray = new int[array.length];
//        for (int i=0; i<array.length; i++) {
//            sortedArray[i] = array[i];
//        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++) {
                if (sortedArray[i]<sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1]=temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static int[] bubbleSortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int temp;
        for (int i=0;i<sortedArray.length;i++) {
            for (int j=0;j<sortedArray.length-i-1;j++) {
                if (sortedArray[j] > sortedArray[j+1]) {
                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = temp;
                }
            }
        }
        return sortedArray;
    }

}
