package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean expected = data[0][0];
        for (int i = 0; i < data.length; i++) {
            if (data[i][i] != expected && data[i][data.length - i] != expected) {
                result = false;
                break;
            }
        }
        return result;
    }
}
