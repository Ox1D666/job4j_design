package ru.job4j.structures.generics;

import java.util.Iterator;
import java.util.Objects;

/**
 * Creating and managing array.
 * @param <T>
 */
public class SimpleArray<T> implements Iterable<T> {
    Object[] array;
    int index = 0;

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
    public void add(T model) {
        array[index++] = model;
    }

    /**
     * Change element in array.
     * @param index place for new element.
     * @param model new element.
     */
    public void set(int index, T model) {
        if (Objects.checkIndex(index, array.length) == index) {
            array[index] = model;
        }
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
        if (Objects.checkIndex(index, array.length) == index) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException();
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
