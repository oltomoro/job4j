package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;

public class ArrayDuplicateTest {
    @Test
    public void whenNotSortedThenSorted() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] inputData = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDuplicate.remove(inputData);
        String[] expected = {"Привет", "Мир", "Супер"};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenNotSorted2ThenSorted() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] inputData = {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] result = arrayDuplicate.remove(inputData);
        String[] expected = {"Привет"};
        Assert.assertThat(result, is(expected));
    }

}
