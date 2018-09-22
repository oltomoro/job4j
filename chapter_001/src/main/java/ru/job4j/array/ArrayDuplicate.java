package ru.job4j.array;

import java.util.Arrays;
import java.util.stream.Collectors;

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
        int resultSize = data.length;
        for (int i = 0; i < resultSize; i++) {
            for (int j = i + 1; j < resultSize; j++) {
                if(data[i].equals(data[j])){
                    data[j] = data[resultSize -1];
                    resultSize--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(data, resultSize);
    }
}
