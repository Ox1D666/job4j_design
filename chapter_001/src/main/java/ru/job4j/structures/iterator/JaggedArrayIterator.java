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
     * Checking for the next item
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        return row < matrix.length && col < matrix[row].length;
    }

    /**
     * Get the value of the next element, and move cursor.
     * @return array value.
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
