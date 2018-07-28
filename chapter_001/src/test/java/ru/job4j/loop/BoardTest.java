package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String ln = System.lineSeparator();
        String result = board.paint(3, 3);
        String expected = String.format("X X%s X %sX X%s", ln, ln, ln);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void when5x2() {
        Board board = new Board();
        String ln = System.lineSeparator();
        String result = board.paint(5, 2);
        String expected = String.format("X X X%s X X %s", ln, ln);
        Assert.assertThat(result, is(expected));
    }
}
