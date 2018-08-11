package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn trn = new Turn();
        int[] input = {1, 2, 3, 4};
        int[] result = trn.turn(input);
        int[] expected = {4, 3, 2, 1};

        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn trn = new Turn();
        int[] input = {1, 2, 3, 4, 5};
        int[] result = trn.turn(input);
        int[] expected = {5, 4, 3, 2, 1};

        Assert.assertThat(result, is(expected));
    }
}
