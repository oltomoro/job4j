package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        // проверяем левую диагональ
        boolean result = true;
        boolean expected = data[0][0];
        for (int i = 0; i < data.length; i++) {
            if (data[i][i] != expected) {
                result = false;
                break;
            }
        }

        if(result) return result;

        // проверяем правую диагональ
        result = true;
        expected = data[0][data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (data[i][data.length - i - 1] != expected) {
                result = false;
                break;
            }
        }

        return result;
    }
}
