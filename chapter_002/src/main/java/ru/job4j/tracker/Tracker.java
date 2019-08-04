package ru.job4j.tracker;

public class Tracker {
    private Item[] item = new Item[100];
    private int counter = 0;

    public Item add(Item item) {
        if (counter != 100) {
            // todo не понятно где именно должен инициализироваться объект Item
            this.item[counter++] = item;
        }

        return null;
    }


}
