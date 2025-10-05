package org.example.cli;

import org.example.Algoritms.InsertionSort;
import org.example.Metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BenchmarkRunner {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== Benchmark Runner =====");
        System.out.println("1. Run benchmark on random array");
        System.out.println("2. Exit");
        System.out.print("Choose option: ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            runBenchmark();
        } else {
            System.out.println("Exiting...");
        }
    }

    private static void runBenchmark() {
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();

        int[] array = generateRandomArray(size);
        System.out.println("Generated array: " + Arrays.toString(array));

        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);

        sorter.sort(array); // Трекер сам внутри фиксирует метрики

        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("===== Metrics =====");
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
