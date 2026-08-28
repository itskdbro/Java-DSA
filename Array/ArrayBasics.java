package Array;

import java.util.ArrayList;

public class ArrayBasics {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        // int[] result = swapAlternate(arr);
        int[] result = alternateExtreme(arr);
        for (int i : result) {
            System.out.println(i);
        }
        // int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        // int[] arr2 = { 7, 2, 8, 9, 5, 6 };
        // System.out.println(arrayIntersection(arr1, arr2));
    }

    static int[] swapAlternate(int[] arr) {
        int size = arr.length;
        int temp = 0;
        for (int i = 0; i < size; i = i + 2) {
            temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return arr;
    }

    static ArrayList<Integer> arrayIntersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    result.add(arr2[j]);
                }
            }
        }
        return result;
    }

    static int[] alternateExtreme(int[] arr) {
        int temp = 0;
        int size = arr.length;

        temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;

        return arr;
    }
}