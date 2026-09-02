package Array;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class ArrayManipulation {
    public static void main(String[] args) {
        // int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        // int[] arr2 = { 2, 4, 5, 6, 7, 8, 9 };
        // LinkedHashSet<Integer> result = unionOfTwoArrays(arr1, arr2);
        // System.out.println(result);
        // int arr[] = { 0, 1, 1, 0, 1, 0 };
        // int[] result = sortZerosAndOnes(arr);

        // int[] arr = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5 };
        // highestAndLowestFreq(arr);
        // int result = getMode(arr);
        // System.out.println(result);
        // int[] arr = {};
        // int[] result = reverseArray(arr, 0, arr.length - 1);
        // int[] result = rightShiftBy1(arr);
        // int[] result = shiftByK(arr, 8);

        // for (int i : result) {
        // System.out.println(i);
        // }
        int[] arrr = { 5, 6, 0, 2, 4, 1, 8, 7 };
        int num = 8;
        System.out.println(missingNum(arrr, num));
    }

    static int[] reverseArray(int[] arr, int start, int end) {
        // TC = O(n) , SC = O(1)
        int temp = 0;

        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    static int[] rightShiftBy1(int[] arr) {
        // TC = O(n) , SC = O(1)
        int size = arr.length;
        int temp = arr[size - 1];

        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    static int[] shiftByK(int[] arr, int k) {
        int size = arr.length;
        if (size == 0) {
            return arr;
        }
        if (k < 0) {
            int[] result = { -1 };
            return result;
        }
        k = k % size;

        // - Method -1 -- TC = O(n), SC = O(n)
        // int[] tempArr = new int[size];
        // int i = size - k;
        // int j = 0;

        // while (i < size) {
        // tempArr[j++] = arr[i++];
        // }
        // j = 0;
        // for (i = k; i < size; i++) {
        // tempArr[i] = arr[j++];
        // }

        // Mehtod - 2 ( Reversal approach) Optimal solution -- TC = O(n) , SC = O(1)

        reverseArray(arr, 0, size - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, size - 1);

        return arr;
    }

    static int getMode(int[] arr) {
        int max = 0;
        int mode = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int i : freq.keySet()) {
            if (max < freq.get(i)) {
                max = freq.get(i);
                mode = i;
            }
        }

        return mode;

    }

    static void highestAndLowestFreq(int[] arr) {
        int high = Integer.MIN_VALUE;
        int highfreqElem = 0;
        int low = Integer.MAX_VALUE;
        int lowFreqElem = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int key : arr) {
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        for (int key : freq.keySet()) {
            if (high < freq.get(key)) {
                high = freq.get(key);
                highfreqElem = key;
            }
            if (low > freq.get(key)) {
                low = freq.get(key);
                lowFreqElem = key;
            }
        }
        System.out.println("highest freq is : " + highfreqElem + " and Lowest freq is : " + lowFreqElem);
    }

    static LinkedHashSet<Integer> unionOfTwoArrays(int[] arr1, int[] arr2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }
        return set;
    }

    static int[] sortZerosAndOnes(int[] arr) {
        // TC = O(n) ,SC = O(1)
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                // swap
                arr[i] = 0;
                arr[j] = 1;
                i++;
                j--;
            }
            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }

        }
        return arr;
    }

    static int missingNum(int[] arr, int num) {
        // TC = O(n), SC = O(1)
        int totalSum = num*(num+1)/2;
        int arrSum = 0;
       
        for (int i : arr) {
            arrSum = arrSum + i;
        }
        return totalSum - arrSum;
    }
}