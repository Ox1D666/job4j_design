package ru.job4j.isp;

import java.util.List;

public class Item {
    private String name;
    private Action action;
    private List<Item> children;

    public Item(String name, List<Item> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Item> getItems() {
        return children;
    }

    public void setChildren(Item child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name;
    }
}
