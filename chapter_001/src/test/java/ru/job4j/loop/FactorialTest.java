package ru.job4j.loop;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class FactorialTest {
    @Test
    public void when5thenFact120() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        int expected = 120;

        Assert.assertThat(result, is(expected));
    }

    @Test
    public void when0thenFact1() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        int expected = 1;

        Assert.assertThat(result, is(expected));
    }
}
