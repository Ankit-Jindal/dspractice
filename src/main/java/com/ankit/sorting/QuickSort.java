package com.ankit.sorting;

public class QuickSort {
    public static void main(String[] args) {

        int[] unsorted = {10, 1, 12, 14, 3, 11, 8};
        quickSort(unsorted,0, unsorted.length -1);

        for (int i : unsorted) {
            System.out.print(i+", ");
        }
    }

    private static void quickSort(int[] array, int min , int max){

        if(min > max) return;
        int pivot = partition(array,min, max);

        quickSort(array, min, pivot - 1 );
        quickSort(array, pivot+1, max);
    }

    private static int partition(int[] array, int min, int max) {
    // take pivot as last element in array

        int pivotIndex = min;
        int lasElem = array[max];
        for(int i = min; i <= max -1 ; i++) {
            if(array[i] < lasElem) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, max);
        return  pivotIndex;
    }

    private static void swap(int[] array , int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
