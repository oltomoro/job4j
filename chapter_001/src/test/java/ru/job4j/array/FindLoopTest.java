package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class FindLoopTest {
    @Test
    public void whenElement7ThenIndex3() {
        FindLoop fl = new FindLoop();
        int[] rst = {1, 9, 6, 7, 2};
        int result = fl.indexOf(rst, 7);
        int expected = 3;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenElement9ThenNotFound() {
        FindLoop fl = new FindLoop();
        int[] rst = {1, 4, 6, 3, 4};
        int result = fl.indexOf(rst, 9);
        int expected = -1;
        Assert.assertThat(result, is(expected));
    }
}
