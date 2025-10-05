package org.example.Metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long accesses = 0;
    private double timeMs = 0;

    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }
    public void incrementAccesses() { accesses++; }
    public void incrementAccesses(int n) { accesses += n; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }
    public double getTimeMs() { return timeMs; }

    public void reset() {
        comparisons = swaps = accesses = 0;
        timeMs = 0;
    }

    public void setTimeMs(double timeMs) { this.timeMs = timeMs; }

        public void exportToCSV(String fileName, int n) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(n + "," + timeMs + "," + comparisons + "," + swaps + "," + accesses + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
