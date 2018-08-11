package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] rst, int el) {
        int result = -1;
        for (int i = 0; i < rst.length; i++) {
            if (rst[i] == el) {
                result = i;
                break;
            }
        }
        return result;
    }
}
