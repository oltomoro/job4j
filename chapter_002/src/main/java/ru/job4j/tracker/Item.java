package ru.job4j.tracker;

import java.util.Objects;
import java.util.Random;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long time;
    private String[] comments;

    public Item(String name, String desc) {
        Random rand = new Random();
        this.id = String.valueOf(System.currentTimeMillis() + rand.nextInt());
        this.name = name;
        this.desc = desc;
        this.time = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return time == item.time &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }
}
