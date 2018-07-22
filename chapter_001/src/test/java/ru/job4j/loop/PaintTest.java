package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;

public class PaintTest {
    @Test
    public void whenHeight3() {
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        StringJoiner expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        expected
                .add("  ^  ")
                .add(" ^^^ ")
                .add("^^^^^");

        Assert.assertThat(result, is(expected.toString()));
    }

    @Test
    public void whenHeight4() {
        Paint paint = new Paint();
        String result = paint.pyramid(4);
        StringJoiner expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        expected
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^");

        Assert.assertThat(result, is(expected.toString()));
    }
}
