package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {2, 7, 3, 5, 0, 9, 6, 1, 4, 8};
        int[] result = bubbleSort.sort(input);
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertThat(result, is(expected));
    }
}
