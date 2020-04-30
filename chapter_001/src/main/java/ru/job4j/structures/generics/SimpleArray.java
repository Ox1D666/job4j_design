package ru.job4j.structures.generics;

import java.util.Iterator;
import java.util.Objects;

/**
 * Creating and managing array.
 * @param <T>
 */
public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int index = 0;

    /**
     * Constructor for array.
     * @param array - array with items.
     */
    public SimpleArray(Object[] array) {
        this.array = array;
    }

    /**
     * Add element in first free cell.
     * @param model
     */
    public void add(T model) {
        array[index++] = model;
    }

    /**
     * Change element in array.
     * @param index place for new element.
     * @param model new element.
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, array.length);
        array[index] = model;
    }

    /**
     * Delete element, and move array one cell to the left.
     * @param index place of deleted el.
     */
    public void remove(int index) {
        if (Objects.checkIndex(index, array.length) == index) {
            for (int i = index; i < array.length - index; i++) {
                array[i] = array[i + 1];
            }
        }
    }

    /**
     * Returns an element by index.
     * @param index place of el.
     * @return el value.
     */
    public Object get(int index) {
        if (!(Objects.checkIndex(index, array.length) == index)) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }
}
