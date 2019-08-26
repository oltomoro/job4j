package ru.jobj.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("New Item", "Test Item");
        tracker.add(newItem);
        Item result = tracker.findById(newItem.getId());
        assertThat(result.getName(), is(newItem.getName()));
    }

    @Test
    public void whenReplaceItemThenTrackerHasNewItem() {
        Tracker tracker = new Tracker();
        Item original1 = new Item("Original Item1", "This is Original Item");
        Item original2 = new Item("Original Item2", "This is Original Item");
        tracker.add(original1);
        tracker.add(original2);
        Item replaced = new Item("Replaced Item", "This is replaced Item");
        boolean result = tracker.replace(original1.getId(), replaced);
        Assert.assertTrue("Ошибка замены элемента", result);
        assertThat(tracker.findById(original1.getId()).getName(), is("Replaced Item"));
        assertThat(tracker.findById(original2.getId()).getName(), is("Original Item2"));
    }

    @Test
    public void whenReplaceNotPresentItemThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item original1 = new Item("Original Item1", "This is Original Item");
        tracker.add(original1);
        Item replaced = new Item("Replaced Item", "This is replaced Item");
        boolean result = tracker.replace("notPresentItem", replaced);
        assertFalse("Замена была выполнена", result);
        assertThat(tracker.findById(original1.getId()).getName(), is("Original Item1"));
    }

    @Test
    public void whenReplaceWithFirstParamIsNullThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item original1 = new Item("Original Item1", "This is Original Item");
        tracker.add(original1);
        Item replaced = new Item("Replaced Item", "This is replaced Item");
        boolean result = tracker.replace(null, replaced);
        assertFalse("Замена была выполнена", result);
        assertThat(tracker.findById(original1.getId()).getName(), is("Original Item1"));
    }

    @Test
    public void whenReplaceWithSecondParamIsNullThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item original1 = new Item("Original Item1", "This is Original Item");
        tracker.add(original1);
        Item replaced = new Item("Replaced Item", "This is replaced Item");
        boolean result = tracker.replace(original1.getId(), null);
        assertFalse("Замена была выполнена", result);
        assertThat(tracker.findById(original1.getId()).getName(), is("Original Item1"));
    }

//    public void whenReplaceWithSecondParamIsNullThenReturnFalse){


    @Test
    public void whenDeleteFirstItemThenDeleteIsSuccess() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        Item item2 = new Item("test2", "test");
        Item item3 = new Item("test3", "test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        boolean resultDelete = tracker.delete(item1.getId());
        Assert.assertTrue("Ошибка удаления элемента", resultDelete);
        assertThat(tracker.findById(item3.getId()).getName(), is(item3.getName()));
        assertThat(tracker.findById(item2.getId()).getName(), is(item2.getName()));
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }

    @Test
    public void whenDeleteMiddleItemThenDeleteIsSuccess() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        Item item2 = new Item("test2", "test");
        Item item3 = new Item("test3", "test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        boolean resultDelete = tracker.delete(item2.getId());
        Assert.assertTrue("Ошибка удаления элемента", resultDelete);
        assertThat(tracker.findById(item1.getId()).getName(), is(item1.getName()));
        assertThat(tracker.findById(item3.getId()).getName(), is(item3.getName()));
        assertThat(tracker.findById(item2.getId()), is(nullValue()));
    }

    @Test
    public void whenDeleteLastItemThenDeleteIsSuccess() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        Item item2 = new Item("test2", "test");
        Item item3 = new Item("test3", "test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        boolean resultDelete = tracker.delete(item3.getId());
        assertTrue("Ошибка удаления элемента", resultDelete);
        assertThat(tracker.findById(item1.getId()).getName(), is(item1.getName()));
        assertThat(tracker.findById(item2.getId()).getName(), is(item2.getName()));
        assertThat(tracker.findById(item3.getId()), is(nullValue()));
    }

    @Test
    public void whenDeleteNotPresentItemThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        tracker.add(item1);

        boolean resultDelete = tracker.delete("notPresentId");
        assertFalse("Удаляемый элемент был найден", resultDelete);
        assertThat(tracker.findById(item1.getId()).getName(), is(item1.getName()));
    }

    @Test
    public void whenDeleteItemWithNullIdThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        tracker.add(item1);
        item1.setId(null);
        boolean resultDelete = tracker.delete(null);
        assertFalse("Удаляемый элемент был найден", resultDelete);
        assertThat(tracker.findAll()[0].getName(), is(item1.getName()));
    }

    @Test
    public void whenDeleteItemAndItemsThenItemsCounterDecrement() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 100; i++) {
            tracker.add(new Item("test" + i, "test"));
        }

        tracker.delete(tracker.findByName("test0")[0].getId());
        Item lastItem = new Item("lastItem", "test");
        tracker.add(lastItem);
        Item result = tracker.findById(lastItem.getId());
        assertThat(result.getName(), is("lastItem"));
    }

    @Test
    public void whenFindAllThenReturnAllItemsWithoutNullItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        Item item2 = new Item("test2", "test");
        tracker.add(item1);
        tracker.add(item2);

        Item[] allItems = tracker.findAll();
        Assert.assertTrue("Количество элементов в возвращаемом массиве больше ожидаемого (2х элементов)", allItems.length == 2);
        assertThat(tracker.findById(item1.getId()).getName(), is("test1"));
        assertThat(tracker.findById(item2.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindAllAndAllElementsIsNullThenReturnEmptyArray() {
        Tracker tracker = new Tracker();
        Item[] allItems = tracker.findAll();
        Assert.assertTrue("Количество элементов в возвращаемом массиве больше ожидаемого (0 элементов)", allItems.length == 0);
    }

    @Test
    public void whenFindByNameThenReturnAllFindedItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        Item item2 = new Item("test2", "test");
        Item item3 = new Item("test1", "test");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] result = tracker.findByName("test1");
        assertTrue("Размер возвращаемого массива больше ожидаемого", result.length == 2);
        assertThat(result[0].getName(), is("test1"));
        assertThat(result[1].getName(), is("test1"));
    }

    @Test
    public void whenFindByNameAndNameNotPresentThenReturnEmptyArray() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        tracker.add(item1);

        Item[] result = tracker.findByName("notPresentName");
        assertTrue("Размер возвращаемого массива больше ожидаемого", result.length == 0);
    }


    @Test
    public void whenFindByNameAndParamIsNullThenReturnEmptyArray() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        tracker.add(item1);

        Item[] result = tracker.findByName("null");
        assertTrue("Размер возвращаемого массива больше ожидаемого", result.length == 0);
    }

    @Test
    public void whenFindByIdThenReturnFindedItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        Item item2 = new Item("test2", "test");
        tracker.add(item1);
        tracker.add(item2);

        Item result = tracker.findById(item2.getId());
        assertThat(result.getName(), is("test2"));
    }

    @Test
    public void whenFindByIdAndIdNotPresentThenReturnNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        tracker.add(item1);

        Item result = tracker.findById("notPresentId");
        assertThat(result, is(nullValue()));
    }

    @Test
    public void whenFindByIdAndIdIsNullThenReturnNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test");
        tracker.add(item1);

        Item result = tracker.findById(null);
        assertThat(result, is(nullValue()));
    }
}
