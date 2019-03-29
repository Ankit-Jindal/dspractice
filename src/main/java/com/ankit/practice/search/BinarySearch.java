package com.ankit.practice.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sorted = {3, 8, 9, 10, 11, 14};
        System.out.println(search(sorted, 31));

    }

    private static int binarySearch(int[] arr, int element, int left, int right) {
        if(left > right) return - 1;

        int middle = (left + right) /2;

        if(arr[middle] == element){
            return middle;
        } else if(arr[middle] > element) {
            return binarySearch(arr, element, left, middle);
        } else {
            return binarySearch(arr, element, middle + 1, right);
        }


    }

    private static int search(int[] arr, int element) {
        return binarySearch(arr,element, 0, arr.length - 1);
    }
}
