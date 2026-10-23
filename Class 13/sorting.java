
package com.abc;

import java.util.Arrays;

public class sorting {

    public static void main(String[] args) {

        int[] arr = {40, 20, 10, 50, 30};

        // Swap two variables
        int a = 10;
        int b = 5;

        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Sorting array in ascending order
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {

                    int tempp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tempp;
                }
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
