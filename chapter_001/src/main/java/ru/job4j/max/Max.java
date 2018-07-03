package ru.job4j.max;

/**
 * @author vladimir
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Вычисляет максимальное число.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @return Результат.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = max(first, second);
        return max(temp, third);
    }
}
