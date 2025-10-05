package org.example;// src/main/java/Main.java
import org.example.Algoritms.InsertionSort;
import org.example.Metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 20;
        int[] arr = new Random().ints(n, 0, 100).toArray();

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        InsertionSort sorter = new InsertionSort();
        sorter.sort(arr);
        PerformanceTracker m = sorter.getMetrics();

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));

        System.out.println("\n--- Metrics ---");
        System.out.println("Comparisons: " + m.getComparisons());
        System.out.println("Swaps:       " + m.getSwaps());
        System.out.println("Accesses:    " + m.getAccesses());
        System.out.println("Time (ms):   " + m.getTimeMs());
    }
}
