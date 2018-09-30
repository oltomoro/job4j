package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Logic3TTest {
    @Test
    public void whenHasXWinnerLeftDiagonal() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerRightDiagonal() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerHorizontal() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerVertical() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerAndOIsPresent() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOWinnerLeftDiagonal() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerRightDiagonal() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerHorizontal() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerVertical() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerAndXIsPresent() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenNotHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(false));
    }
}
