package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class CheckTest {
    @Test
    public void whenAllElementsOfArrayIsTrue() {
        Check check = new Check();
        boolean[] input = {true, true, true};
        boolean result = check.mono(input);
        boolean expected = true;

        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenAllElementsOfArrayIsFalse() {
        Check check = new Check();
        boolean[] input = {false, false, false};
        boolean result = check.mono(input);
        boolean expected = true;

        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenElementsOfArrayContainsTrueAndFalse() {
        Check check = new Check();
        boolean[] input = {false, true, false};
        boolean result = check.mono(input);
        boolean expected = false;

        Assert.assertThat(result, is(expected));
    }
}
