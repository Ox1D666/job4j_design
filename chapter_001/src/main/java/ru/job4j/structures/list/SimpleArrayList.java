package ru.job4j.structures.list;

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
     * Amount of elements.
     */
    private int size = 0;

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

    public int getSize() {
        return size;
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
        if (size >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = model;
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
        Objects.checkIndex(index, this.size);
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
                return iterIndex < size;
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
