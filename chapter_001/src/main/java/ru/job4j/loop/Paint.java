package ru.job4j.loop;

/**
 * Paint
 *
 * @author ism.vladimir
 */
public class Paint {
    /**
     * Строит пирамиду заданной высоты.
     *
     * @param height Высота пирамиды.
     * @return возвращает строку с построенной пирамидой.
     */
    public String pyramid(int height) {
        StringBuilder pyramid = new StringBuilder();
        String ls = System.lineSeparator();
        int width = height + height - 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i >= height - j - 1 && i + height - 1 >= j) {
                    pyramid.append("^");
                } else {
                    pyramid.append(" ");
                }
            }
            pyramid.append(ls);
        }

        return pyramid.toString();
    }
}
