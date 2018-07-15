package ru.job4j.loop;

/**
 * Counter
 *
 * @author Ism Vladimir (is.vladimir@testmail.com)
 */
public class Counter {
    /**
     * Подсчитывает сумму всех четных чисел в заданном диапазоне.
     * @param start Начальное число.
     * @param finish Конечное число.
     * @return Возвращает сумму.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
