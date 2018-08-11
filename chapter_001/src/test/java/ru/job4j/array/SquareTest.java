package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        Square square = new Square();
        int bound = 3;
        int[] result = square.calculate(bound);
        int[] expected = {1, 4, 9};
        Assert.assertThat(result, is(expected));
    }
}
