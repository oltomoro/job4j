package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint
 *
 * @author ism.vladimir
 */
public class Paint {

    /**
     * Строит равностороннюю пирамиду заданной высоты.
     *
     * @param height Высота пирамиды.
     * @return возвращает строку с построенной пирамидой.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (i, j) -> i >= height - j - 1 && i + height - 1 >= j
        );
    }

    /**
     * Строит пирамиду по заданным параметрам.
     *
     * @param height Высота пирамиды.
     * @return возвращает строку с построенной пирамидой.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
