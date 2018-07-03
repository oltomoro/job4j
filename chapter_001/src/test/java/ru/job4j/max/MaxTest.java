package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = 2;
        assertThat(maximum.max(1, 2), is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maximum = new Max();
        int result = 2;
        assertThat(maximum.max(2, 1), is(2));
    }

    @Test
    public void whenFirstLessSecondAndThird() {
        Max maximum = new Max();
        int result = 3;
        assertThat(maximum.max(1, 2, 3), is(3));
    }
}
