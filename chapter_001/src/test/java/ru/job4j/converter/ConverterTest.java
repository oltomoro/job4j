package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubbleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubbleToDollar(60);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void when70RubbleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubbleToEuro(70);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void when1DollarToRubbleThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRubble(1);
        int expected = 60;
        assertThat(result, is(expected));
    }

    @Test
    public void when1EuroToRubbleThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRubble(1);
        int expected = 70;
        assertThat(result, is(expected));
    }
}
