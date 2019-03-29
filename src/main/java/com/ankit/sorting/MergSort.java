package com.ankit.sorting;

public class MergSort {
    public static void main(String[] args) {
        int[] unsorted = {10, 14, 3, 11, 8, 9};// 5/2= 2
        System.out.println("mergSort1");
        int[] sorted = mergeSort1(unsorted);

        for (int i : sorted) {
            System.out.print(i+", ");
        }
        System.out.println();
        int[] unsorted1 = {10, 14, 3, 11, 8, 9};
        mergSort(unsorted1);
    }

    private static void mergSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergSortAlg(arr, temp, 0, arr.length -1 );
        System.out.println("mergSort");
        for (int i : temp) {
            System.out.print(i+", ");
        }
    }

    private static void mergSortAlg(int[] arr, int[] temp, int leftId, int rightIdx) {
        if(leftId >= rightIdx) return;

        int midIdx = (leftId + rightIdx) / 2;

        mergSortAlg(arr, temp, leftId, midIdx);
        mergSortAlg(arr, temp, midIdx + 1, rightIdx);
        mergeTwoSortedArray(arr, temp, leftId, rightIdx);

    }

    private static void mergeTwoSortedArray(int [] arr, int[] temp, int leftIdx, int rghtIdx) {

        int larrStart = leftIdx;
        int lefArrEnd = (leftIdx + rghtIdx) / 2;

        int rArrStart = lefArrEnd + 1;
        int rArrEnd = rghtIdx;

        int intoTempIdx = leftIdx;

        while(larrStart <= lefArrEnd && rArrStart <= rArrEnd) {
            if(arr[larrStart] <= arr[rArrStart]) {
                temp[intoTempIdx] = arr[larrStart];
                larrStart ++;
            } else {
                temp[intoTempIdx] = arr[rArrStart];
                rArrStart ++;
            }
            intoTempIdx ++;
        }
        while (larrStart <= lefArrEnd) {
            temp[intoTempIdx] = arr[larrStart];
            larrStart ++;
            intoTempIdx++;
        }
        while (rArrStart <= rArrEnd) {
            temp[intoTempIdx] = arr[larrStart];
            rArrStart ++;
            intoTempIdx++;
        }

        System.arraycopy(temp,leftIdx,arr,leftIdx,rghtIdx - leftIdx + 1);

    }

    private static int[] mergeSort1(int[] array) {
        if(array.length < 2) return array;
        int left = 0;
        int right = array.length - 1;
        int mid =  (left + right) / 2;

        int[] leftA = new int[mid + 1];
        int[] rightA = new int[right - mid];
        for(int i = 0 ; i <= leftA.length - 1 ; i++) leftA[i] = array[left + i];
        for(int i = 0 ; i <= rightA.length - 1 ; i++) rightA[i] = array[mid + 1 + i];

        leftA = mergeSort1(leftA);
        rightA = mergeSort1(rightA);
        return merg2SortedArr(leftA,rightA);
    }

    private static int[] merg2SortedArr(int[] left, int[] right) {

        int[] neWARR = new int[left.length + right.length];
        int lI = 0;
        int rI = 0;
        int mI = 0;
        while(lI <= left.length - 1 && rI <= right.length -1 ) {
            if(left[lI] <= right[rI]){
                neWARR[mI] = left[lI];
                lI++;
            } else {
                neWARR[mI] = right[rI];
                rI++;
            }
            mI++;
        }

        while (lI < left.length) {
            neWARR[mI] = left[lI];
            lI++;
            mI++;
        }
        while (rI < right.length) {
            neWARR[mI] = right[rI];
            rI++;
            mI++;
        }

        return neWARR;
    }
}
