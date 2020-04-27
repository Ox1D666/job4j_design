package ru.job4j.structures.generics;

import java.util.Iterator;

/**
 * Creating and managing array.
 * @param <T>
 */
public class SimpleArray<T> implements Iterable<T> {
    Object[] array;
    int index = 0;
    T model;

    /**
     * Constructor for array.
     * @param size - array size.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Add element in first free cell.
     * @param model
     */
    private void add(T model) {
        array[index++] = model;
    }

    /**
     * Change element in array.
     * @param index place for new element.
     * @param model new element.
     */
    private void set(int index, T model) {
        array[index] = model;
    }

    /**
     * Delete element, and move array one cell to the left.
     * @param index place of deleted el.
     */
    private void remove(int index) {
        for (int i = index; i < array.length - index; i++) {
            array[i] = array[i + 1];
        }
    }

    /**
     * Returns an element by index.
     * @param index place of el.
     * @return el value.
     */
    private Object get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
