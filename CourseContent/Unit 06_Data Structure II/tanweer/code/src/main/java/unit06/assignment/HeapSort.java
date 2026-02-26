package unit06.assignment;

import java.util.Arrays;
import java.util.Random;

import unit06.ArrayHeap;

public class HeapSort {

    /**
     * In-place (destructive) ascending sort.
     * Uses a min-heap:
     *  - add all items
     *  - repeatedly removeMin into array from index 0..n-1
     */
    public static void heapSort(int[] intArray) {
        if (intArray == null) return;

        ArrayHeap heap = new ArrayHeap();
        for (int v : intArray) {
            heap.add(v);
        }

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = heap.remove();
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101); // 0..100 inclusive
        }

        System.out.println("Before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After : " + Arrays.toString(arr));
    }
}
