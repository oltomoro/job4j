package ru.job4j.array;

public class Turn {
    public int[] turn(int[] array) {
        // 1 2 3 4
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
