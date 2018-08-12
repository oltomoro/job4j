package ru.job4j.array;

/**
 * Класс работы с матрицами
 */
public class Matrix {
    /**
     * Создает таблицу умножения заданного размера
     *
     * @param size размер матрицы
     * @return массив с заполненной матрицей
     */
    public int[][] multiple(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                matrix[i - 1][j - 1] = i * j;
            }
        }
        return matrix;
    }
}
