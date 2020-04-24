package ru.job4j.structures.iterator;

import java.util.Iterator;

/**
 * Iterator for array/jaggedarray.
 */
public class  JaggedArrayIterator<T> implements Iterator<Integer> {
    private final int[][] matrix;
    /**
     * [row] & [column].
     */
    private int row, col;

    public JaggedArrayIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Checking for the next item.
     * @return true if we have next num.
     */
    @Override
    public boolean hasNext() {
        return row < matrix.length && col < matrix[row].length;
    }

    /**
     * Get the value of the next element, and move cursor.
     * @return int value.
     */
    @Override
    public Integer next() {
        Integer result = matrix[row][col++];
        if (col >= matrix[row].length) {
            row++;
            col = 0;
        }
        return result;
    }
}
