package org.example;

import org.example.Algoritms.SelectionSort;
import org.example.Metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 20;
        boolean export = args.length > 1 && args[1].equalsIgnoreCase("export");
        String csvFile = "selectionsort_results.csv";

        int[] arr = new Random().ints(n, 0, 100).toArray();

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        SelectionSort sorter = new SelectionSort();
        sorter.sort(arr);
        PerformanceTracker metrics = sorter.getMetrics();

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));

        System.out.println("\n--- Performance Metrics ---");
        System.out.println("Array size:   " + n);
        System.out.println("Comparisons:  " + metrics.getComparisons());
        System.out.println("Swaps:        " + metrics.getSwaps());
        System.out.println("Accesses:     " + metrics.getAccesses());
        System.out.printf("Time (ms):    %.3f%n", metrics.getTimeMs());

        if (export) {
            metrics.exportToCSV(csvFile, n);
            System.out.println("\nMetrics exported to: " + csvFile);
        }
    }
}
