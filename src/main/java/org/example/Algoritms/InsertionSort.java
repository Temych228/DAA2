package org.example.Algoritms;

public class InsertionSort {

    private static long comparisons;
    private static long swaps;
    private static long arrayAccesses;

    public InsertionSort() {
        resetMetrics();
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        resetMetrics();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            arrayAccesses++;
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                arrayAccesses++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    arrayAccesses += 2;
                    swaps++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            arrayAccesses++;
        }
    }

    private static void resetMetrics() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
}
