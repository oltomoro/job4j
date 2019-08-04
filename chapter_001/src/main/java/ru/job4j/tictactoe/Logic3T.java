package ru.job4j.tictactoe;


import java.util.function.Predicate;

/**
 * Класс реализующий логику работы игры
 */
public class Logic3T {
    private final Figure3T[][] table;

    /**
     * Конструктор класса
     *
     * @param table двумерный массив фигур
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяет выиграли ли крестики
     *
     * @return true - если выиграли, false - если нет
     */
    public boolean isWinnerX() {
        return checkWinner(Figure3T::hasMarkX);
    }

    /**
     * Проверяет выиграли ли нолики
     *
     * @return true - если выиграли, false - если нет
     */
    public boolean isWinnerO() {
        return checkWinner(Figure3T::hasMarkO);
    }

    /**
     * Проверяет есть ли свободные клетки
     *
     * @return true - если есть, false - если нет
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
            if (result){
                break;
            }
        }
        return result;
    }

    /**
     * Проверяет последовательность заполненных значений начиная от заданной клетки и следуя указанному вектору проверки
     *
     * @param predicate занчение устанавливает последовательность чего проверять, крестиков или ноликов
     * @param startX координаты стартовой клетки по оси Х
     * @param startY координаты стартовой клетки по оси Y
     * @param deltaX вектор движения проверки по оси Х
     * @param deltaY вектор движения проверки по оси Y
     * @return
     */
    private boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            Figure3T cell = table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Проверяет выиграли ли крестики либо нолики
     *
     * @param predicate занчение устанавливает кто именно должен был выигарть, крестики либо нолики
     * @return
     */
    private boolean checkWinner(Predicate<Figure3T> predicate) {
        return fillBy(predicate, 0, 0, 0, 1)
                || fillBy(predicate, 1, 0, 0, 1)
                || fillBy(predicate, 2, 0, 0, 1)
                || fillBy(predicate, 0, 0, 1, 0)
                || fillBy(predicate, 0, 1, 1, 0)
                || fillBy(predicate, 0, 2, 1, 0)
                || fillBy(predicate, 0, 0, 1, 1)
                || fillBy(predicate, 0, 2, 1, -1);
    }
}
