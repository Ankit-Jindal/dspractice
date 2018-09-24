package com.ankit.practice.tree;

import java.util.Arrays;

public class MaxHeap {

    private int[] heap;

    private int size = 0;
    private int capapcity = 0;

    public MaxHeap() {
        capapcity = 10;
        heap = new int[capapcity];
    }

    public MaxHeap(int initalCapacity) {
        this.capapcity = initalCapacity;
        this.heap = new int[capapcity];
    }

    private int leftChildIndex(int nodeIndex){
        return 2*nodeIndex + 1;
    }

    private int rightChildIndex(int nodeIndex) {
        return  2*nodeIndex + 2;
    }

    private int leftChild(int noodeIndex) {
        return heap[leftChildIndex(noodeIndex)];
    }

    private int rightChild(int nodeIndex) {
        return heap[rightChildIndex(nodeIndex)];
    }

    private int parentIndex(int nodeIndex) {
        return (nodeIndex - 1)/2;
    }

    private int parent(int nodeIndex) {
        return heap[parentIndex(nodeIndex)];
    }

    private boolean hasLeftChild(int nodeIndex) {
        return leftChildIndex(nodeIndex) < size;
    }
    private boolean hasRightChild(int nodeIndex) {
        return  rightChildIndex(nodeIndex) < size;
    }

    private boolean hasParent(int nodeIndex) {
        return parentIndex(nodeIndex) >= 0;
    }

    private void ensureCapacity() {
        if(size + 1 < capapcity) {
            this.heap = Arrays.copyOf(this.heap, capapcity * 2);
            capapcity = capapcity * 2;
        }
    }

    private void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }

    public int peek() {
        if(size == 0 ) throw new IllegalStateException(" heap is empty");
        return heap[0];
    }

    public int poll() {
        if(size == 0 ) throw new IllegalStateException("Heap is empty");
        int element = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return element;
    }

    private void heapifyDown(){
        int currIdx = 0;
        while (hasLeftChild(currIdx)) {
            int maxIndex = leftChildIndex(currIdx);
            if(hasRightChild(currIdx) && (leftChild(currIdx) < rightChild(currIdx))) {
                maxIndex = rightChildIndex(currIdx);
            }
            if(heap[currIdx] < heap[maxIndex]) {
                swap(currIdx, maxIndex);
                currIdx = maxIndex;
            } else {
                break;
            }
        }
    }

    public int add(int element) {
        ensureCapacity();
        heap[size] = element;
        size++;
        return heapyFyUp();
    }


    private int heapyFyUp() {
        int currIndex = size -1 ;
        while (hasParent(currIndex) && heap[currIndex] > parent(currIndex)) {
            swap(currIndex, parentIndex(currIndex));
            currIndex = parentIndex(currIndex);
        }
        return currIndex;
    }


}
