package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar arrayChar = new ArrayChar("Autotesting");
        boolean result = arrayChar.startWith("Auto");
        boolean expected = true;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Autotesting");
        boolean result = arrayChar.startWith("Autop");
        boolean expected = false;
        Assert.assertThat(result, is(expected));
    }
}
