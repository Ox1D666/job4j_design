package ru.job4j.structures.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for even numbers in array.
 */
public class EvenIterator implements Iterator<Integer> {
    /**
     * Array with nums.
     */
    private final int[] array;
    /**
     * Cursor position.
     */
    private int index = 0;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    /**
     * Check next even number
     *
     * @return true, array have once more even num/false array don't have more even number
     */
    @Override
    public boolean hasNext() {
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                index = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Find next even number(after index) in array.
     *
     * @return value of number.
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
