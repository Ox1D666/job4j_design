package ru.job4j.structures.set;

import ru.job4j.structures.generics.store.SimpleArray;
import ru.job4j.structures.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArrayList<T> simpleArrayList = new SimpleArrayList<T>();

    public boolean add(T value) {
        boolean match = false;
        for (int i = 0; i < simpleArrayList.getIndex(); i++) {
            if (simpleArrayList.get(i).equals(value)) {
                match = true;
                break;
            }
        }
        if (!match) {
            simpleArrayList.add(value);
        }
        return match;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArrayList.iterator();
    }
}
