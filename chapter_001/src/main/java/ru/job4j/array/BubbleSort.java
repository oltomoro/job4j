package ru.job4j.array;

/**
 * Сортировка медодом перестаноки (пузырьком)
 */
public class BubbleSort {
    /**
     * Метод сортирует массив поданный на вход
     *
     * @param input массив который будет сортироваться
     * @return отсортированный массив
     */
    public int[] sort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }
}
