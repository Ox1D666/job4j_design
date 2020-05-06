package ru.job4j.structures.set;

import ru.job4j.structures.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArrayList<T> simpleArrayList = new SimpleArrayList<T>();

    public void add(T value) {
        boolean match = false;
        for (int i = 0; i < simpleArrayList.getSize(); i++) {
            if (value.equals(simpleArrayList.get(i))) {
                match = true;
                break;
            }
        }
        if (!match) {
            simpleArrayList.add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArrayList.iterator();
    }
}
