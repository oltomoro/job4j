package ru.job4j.converter;

/**
 * Конвертер валюты.
 */
public class Converter {
    /**
     * Содержит курс доллара к рублю
     */
    private int dollarCourse = 60;

    /**
     * Содержит курс евро к рублю
     */
    private int euroCourse = 70;


    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли
     * @return доллары
     */
    public int rubbleToDollar(int value) {
        return value / this.dollarCourse;
    }

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли
     * @return евро
     */
    public int rubbleToEuro(int value) {
        return value / this.euroCourse;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары
     * @return рубли
     */
    public int dollarToRubble(int value) {
        return value * this.dollarCourse;
    }

    /**
     * Конвертируем евро в рубли
     *
     * @param value евро
     * @return рубли
     */
    public int euroToRubble(int value) {
        return value * this.euroCourse;
    }

}
