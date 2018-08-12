package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MatrixTest {
    @Test
    public void whenMatrix2x2() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(2);
        int[][] expected = {
                {1, 2},
                {2, 4}
        };
        Assert.assertThat(result, is(expected));
    }
}
