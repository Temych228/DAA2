package org.example.Algoritms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        SelectionSort sorter = new SelectionSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        SelectionSort sorter = new SelectionSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort sorter = new SelectionSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        SelectionSort sorter = new SelectionSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {5, 1, 3, 3, 2, 5};
        int[] expected = {1, 2, 3, 3, 5, 5};
        SelectionSort sorter = new SelectionSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRandomArraysAgainstJavaSort() {
        Random rand = new Random(42);
        for (int n : new int[]{10, 50, 200}) {
            int[] arr = rand.ints(n, 0, 1000).toArray();
            int[] expected = arr.clone();
            Arrays.sort(expected);
            SelectionSort sorter = new SelectionSort();
            sorter.sort(arr);
            assertArrayEquals(expected, arr, "Failed for size " + n);
        }
    }
}
