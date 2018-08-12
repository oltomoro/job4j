package ru.job4j.array;

/**
 * Обертка над строкой
 */
public class ArrayChar {
    private char[] data;

    /**
     * Конструктор
     *
     * @param line исходная строка
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет начинается ли слово с указанного префикса
     *
     * @param prefix префикс
     * @return результат выполнения true либо false
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] prefixChar = prefix.toCharArray();
        for (int i = 0; i < prefixChar.length; i++) {
            if (prefixChar[i] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
