package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

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
     *
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
     *
     * @param id       id заявки которую которую нужно заменить
     * @param nextItem новая заявка которой нужно заменить предыдущую
     * @return результат выполнения true/false
     */
    public boolean replace(String id, Item nextItem) {
        boolean result = false;
        int itemIndex = getItemIndex(item -> item != null && item.getId().equals(id));
        if (nextItem != null && id != null && itemIndex != -1) {
            nextItem.setId(id);
            this.items[itemIndex] = nextItem;
            result = true;
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
//                counter--;
//                result = true;
//            }
//        }
//        return result;
//    }

    /**
     * Удаляет по id элемент из массива и уменьшает счетчик количества элементов на 1
     *
     * @param id - id удаляемого элемента
     * @return результат выполнения true/false
     */
    public boolean delete(String id) {
        boolean result = false;
        if (id == null) return result;
        int itemIndex = getItemIndex(item -> item != null && item.getId().equals(id));
        if (itemIndex != -1){
            Item[] itemsCopy = new Item[this.items.length];
            System.arraycopy(this.items, 0, itemsCopy, 0, itemIndex);
            System.arraycopy(this.items, itemIndex + 1, itemsCopy, itemIndex, this.items.length - itemIndex - 1);
            this.items = itemsCopy;
            counter--;

            result = true;
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
     *
     * @return массив найденных заявок
     */
    public Item[] findAll() {
        return Arrays.stream(this.items)
                .filter(Objects::nonNull)
                .toArray(Item[]::new);
    }

    /**
     * Находит в массиве все заявки с указанным именем
     *
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
     *
     * @param id - id искомой заявки
     * @return объект найденной заявки, если ничего не найдено, то null
     */
    //todo проверить, что item ссылается на тот же объект
    public Item findById(String id) {
        Item item = getItem(i -> i != null && i.getId().equals(id));
        return id != null && item != null ? item : null;
    }

//    public Item findById(String id) {
//        Item item = null;
//        if (id == null) return item;
//
//        for (int i = 0; i < this.items.length; i++) {
//            if (this.items[i] != null && this.items[i].getId().equals(id)) {
//                item = this.items[i];
//                break;
//            }
//        }
//        return item;
//    }

    /**
     * Генерирует случайный id
     * @return сгенерированный id
     */
    private String generateId() {
        Random rand = new Random();
        return String.valueOf(System.currentTimeMillis() + rand.nextInt());
    }

    /**
     * Находит заявку по заданному условию
     * @param predicate условие по которому происходит поиск
     * @return ссылка на объект Item найденной заяки
     */
    private Item getItem(Predicate<Item> predicate) {
        Item item = null;
        for (Item it : this.items) {
            if (predicate.test(it)) {
                item = it;
            }
        }
        return item;
    }

    /**
     * Находит id заявки по заданному условию
     * @param predicate условие по которому происходит поиск
     * @return id найденной заявки
     */
    private int getItemIndex(Predicate<Item> predicate) {
        int itemIndex = -1;
        for (int i = 0; i < this.items.length; i++) {
            if (predicate.test(this.items[i])) {
                itemIndex = i;
            }
        }
        return itemIndex;
    }

}
