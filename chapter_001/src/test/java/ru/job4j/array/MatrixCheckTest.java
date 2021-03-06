package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        boolean expected = true;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenDataMonoByTrueAndFalseThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false},
                {false, true}
        };
        boolean result = matrixCheck.mono(input);
        boolean expected = true;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenDataLeftDiagonalByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false, false},
                {false, true, false},
                {false, false, true}
        };
        boolean result = matrixCheck.mono(input);
        boolean expected = true;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenDataRightDiagonalByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {false, false, true},
                {false, true, false},
                {true, false, false}
        };
        boolean result = matrixCheck.mono(input);
        boolean expected = true;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        boolean expected = false;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenData() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = {
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        boolean result = matrixCheck.mono(input);
        Assert.assertThat(result, is(true));
    }
}
