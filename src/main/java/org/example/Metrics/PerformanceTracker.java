package org.example.Metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private static long comparisons = 0;
    private static long swaps = 0;
    private static long arrayAccesses = 0;

    public static void reset() {
        comparisons = swaps = arrayAccesses = 0;
    }

    public static void incrementComparisons() { comparisons++; }
    public static void incrementSwaps() { swaps++; }
    public static void incrementArrayAccesses() { arrayAccesses++; }
    public static void incrementArrayAccesses(int n) { arrayAccesses += n; }

    public static long getComparisons() { return comparisons; }
    public static long getSwaps() { return swaps; }
    public static long getArrayAccesses() { return arrayAccesses; }

    public static void exportToCSV(String fileName, int n, long timeNs) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(n + "," + timeNs + "," + comparisons + "," + swaps + "," + arrayAccesses + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}