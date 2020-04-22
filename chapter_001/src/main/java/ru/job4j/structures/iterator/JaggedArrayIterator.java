package ru.job4j.structures.iterator;

import java.util.Iterator;
/*

 */
public class  JaggedArrayIterator<T> implements Iterator<Integer> {
    private final int[][] matrix;
    private int row, col;

    public JaggedArrayIterator(int[][] matrix) {
        this.matrix = matrix;
    }


    @Override
    public boolean hasNext() {
        return row < matrix.length && col < matrix[row].length;
    }

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
