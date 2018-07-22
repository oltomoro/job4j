package ru.job4j.loop;

/**
 * Шахматная доска
 *
 * @author Ism Vladimir (is.vladimir@testmail.com)
 */
public class Board {
    /**
     * Рисует доску заданного размера в псевдографике
     *
     * @param width
     * @param height
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ls = System.lineSeparator();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
        }

        return screen.toString();
    }
}
