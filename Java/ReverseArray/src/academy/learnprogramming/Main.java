package academy.learnprogramming;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 5, 3, 7, 11, 9, 15};
        System.out.println("Array = "+ Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array = "+ Arrays.toString(array));

    }

    private static void reverse(int[] array) {
        int i = 0;
        int j = array.length -1 ;
        int temp;
        while (i<j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}