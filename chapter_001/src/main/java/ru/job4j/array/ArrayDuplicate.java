package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для работы с дубликатами в массивах
 */
public class ArrayDuplicate {
    /**
     * Удаление дубликатов в массиве
     *
     * @param data исходный массив
     * @return массив без дубликатов
     */
    public String[] remove(String[] data) {
        int index = 0;
        for (int i = 0; i < data.length - 1; i++) {
            int last = data.length - 1 - i;
            for (int j = i; j < last; j++) {
                if (data[i].equals(data[j + 1])) {
                    String tmp = data[last];
                    data[last] = data[j + 1];
                    data[j + 1] = tmp;
                    index = last; // запоминаем индекс с которого начинаются дубликаты
                }
            }
        }
        return Arrays.copyOf(data, index);
    }
}
