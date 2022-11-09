package academy.learnprogramming;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // value types
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = "+myIntValue);
        System.out.println("anotherIntValue = "+anotherIntValue);

        anotherIntValue++;
        System.out.println("myIntValue = "+myIntValue);
        System.out.println("anotherIntValue = "+anotherIntValue);

        // reference types
        int[] myIntArray = new int[5];
        int[] anotherIntArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = "+Arrays.toString(anotherIntArray));

        anotherIntArray[2] = 5;
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = "+Arrays.toString(anotherIntArray));

        anotherIntArray = new int[] {4, 5, 6, 7, 8};
        modifyArray(myIntArray);
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = "+Arrays.toString(anotherIntArray));
    }

    private static void modifyArray(int[] array) {
        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5}; // dereferncing

    }
}
