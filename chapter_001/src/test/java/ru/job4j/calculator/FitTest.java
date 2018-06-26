package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(195);
        assertThat(weight, closeTo(109.2, 0.1));
    }

    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(180);
        assertThat(weight, closeTo(80.5, 0.1));
    }
}
