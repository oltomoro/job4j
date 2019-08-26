package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @author ism.vladimir
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Максимальное количество заявок в трекере
     */
    private final int ITEMS_COUNT = 100;

    /**
     * Массив содержащий в себе все заявки
     */
    private Item[] items = new Item[ITEMS_COUNT];

    /**
     * Счетчик заявок в трекере
     */
    private int counter = 0;

    /**
     * Добавляет новую заявку в массив заявок
     * @param item добавляемая заявка
     * @return заявка
     */
    public Item add(Item item) {
        if (counter < ITEMS_COUNT) {
            item.setId(generateId());
            this.items[counter++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("Превышено максимальное количество заявок (%s шт.)", ITEMS_COUNT));
        }
        return item;
    }

    /**
     * Заменяет в массиве заявку на новую. Заменяемую заявку ищет по id
     * @param id id заявки которую которую нужно заменить
     * @param item новая заявка которой нужно заменить предыдущую
     * @return результат выполнения true/false
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        if (item == null || id == null) return result;

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

//    public boolean deleteNative(String id) {
//        boolean result = false;
//
//        for (int i = 0; i < this.items.length; i++) {
//            if (this.items[i].getId().equals(id)) {
//                for (int j = i; j < this.items.length - 1; j++) {
//                    this.items[j] = this.items[j + 1];
//                }
//                result = true;
//            }
//        }
//        return result;
//    }

    /**
     * Удаляет по id элемент из массива и уменьшает счетчик количества элементов на 1
     * @param id - id удаляемого элемента
     * @return результат выполнения true/false
     */
    public boolean delete(String id) {
        boolean result = false;
        if (id == null) return result;

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                Item[] itemsCopy = new Item[this.items.length];
                System.arraycopy(this.items, 0, itemsCopy, 0, i);
                System.arraycopy(this.items, i + 1, itemsCopy, i, this.items.length - i - 1);
                this.items = itemsCopy;
                counter--;

                result = true;
                break;
            }
        }
        return result;
    }

//    // здесь не ссылаются
//    public Item[] findAllNative() {
//        int index = 0;
//        for (int i = 0; i < this.items.length; i++) {
//            if (this.items[i] == null) {
//                index = i;
//                break;
//            }
//        }
//        return Arrays.copyOfRange(this.items, 0, index + 1);
//    }

    /**
     * Находит все заявки в массиве
     * @return массив найденных заявок
     */
    public Item[] findAll() {
        return Arrays.stream(this.items)
                .filter(Objects::nonNull)
                .toArray(Item[]::new);
    }

    /**
     * Находит в массиве все заявки с указанным именем
     * @param name - имя искомой заявки
     * @return массив найденных заявок
     */
    public Item[] findByName(String name) {
        return Arrays.stream(this.items)
                .filter(Objects::nonNull)
                .filter(f -> f.getName().equals(name))
                .toArray(Item[]::new);
    }

    /**
     * Находит в массиве заявку по id
     * @param id - id искомой заявки
     * @return объект найденной заявки, если ничего не найдено, то null
     */
    public Item findById(String id) {
        Item item = null;
        if (id == null) return item;

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item = this.items[i];
                break;
            }
        }
        return item;
    }

    private String generateId() {
        Random rand = new Random();
        return String.valueOf(System.currentTimeMillis() + rand.nextInt());
    }

    // попробовать использовать предикат
    // только сначала написать тесты на все методы без предиката
    // и сначала ЗАКОММИТИТЬ версию без предиката
    // предиткат можно сделать стримом
//    private int getItemIndex(Item item, Predicate predicate){
//        for (int i = 0; i<items.length; i++){
//
//        }
//    }


}
