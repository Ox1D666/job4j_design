package ru.job4j.structures.set;

import ru.job4j.structures.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArrayList<T> simpleArrayList = new SimpleArrayList<T>();

    public void add(T value) {
        if (!contains(value)) {
            simpleArrayList.add(value);
        }
    }

    public boolean contains(T value) {
        boolean match = false;
        for (int i = 0; i < simpleArrayList.getSize(); i++) {
            if (value.equals(simpleArrayList.get(i))) {
                match = true;
                break;
            }
        }
        return match;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArrayList.iterator();
    }
}
