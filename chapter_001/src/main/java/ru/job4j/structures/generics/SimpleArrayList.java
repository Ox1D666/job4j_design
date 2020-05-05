package ru.job4j.structures.generics;

import java.util.*;

/**
 * Creating ArrayList.
 *
 * @param <T>
 */
public class SimpleArrayList<T> implements Iterable<T> {
    /**
     * Container for arraylist.
     */
    private Object[] container;

    /**
     * Place number of the item in arraylist
     */
    private int index = 0;

    /**
     * This var is modified when we change the list.
     */
    private int modCount = 0;

    /**
     * Constructor for arraylist, with default size 100.
     */
    public SimpleArrayList() {
        this.container = new Object[100];
    }

    /**
     * Constructor for arraylist.
     *
     * @param size - arraylist size.
     */
    public SimpleArrayList(int size) {
        this.container = new Object[size];
    }

    /**
     * Add item in first free cell, and increase the size in case of overflow.
     *
     * @param model - item to add.
     */
    public void add(T model) {
        if (index >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[index++] = model;
        modCount++;
    }

    /**
     * Return item by index.
     *
     * @param index place of item.
     * @return el value.
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterIndex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[iterIndex++];
            }
        };
    }
}
