package ru.job4j.calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void whenAdd1Plus1Then2(){
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtract1Minus1Then0(){
        Calculator calc = new Calculator();
        calc.subtract(1D,1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDiv2Minus2Then1(){
        Calculator calc = new Calculator();
        calc.div(2D,2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiple2On2Then4(){
        Calculator calc = new Calculator();
        calc.multiple(2D,2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }


}
