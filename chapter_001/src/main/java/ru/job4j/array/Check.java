package ru.job4j.array;

/**
 * Check array
 *
 * @author Ism Vladimir (is.vladimir@testmail.com)
 */
public class Check {
    /**
     * Проверяет, что все элементы массива равны либо true, либо false
     *
     * @param data массив который нужно проверить
     * @return результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean expected = data[0];

        for (boolean d : data) {
            if (d != expected) {
                result = false;
                break;
            }
        }

        return result;
    }
}
