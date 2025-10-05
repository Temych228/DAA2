package org.example.Algoritms;

import org.example.Metrics.PerformanceTracker;

public class SelectionSort {
    private final PerformanceTracker metrics = new PerformanceTracker();

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        long start = System.nanoTime();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                metrics.incrementComparisons();
                metrics.incrementAccesses(2);
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                metrics.incrementSwaps();
                metrics.incrementAccesses(4);
            }
        }

        long end = System.nanoTime();
        metrics.setTimeMs((end - start) / 1_000_000.0);
    }

    public PerformanceTracker getMetrics() {
        return metrics;
    }
}
