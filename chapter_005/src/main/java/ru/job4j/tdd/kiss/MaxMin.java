package ru.job4j.tdd.kiss;

import java.util.Comparator;
import java.util.List;

/**
 * Calculate max and min of two elements by comparator.
 */
public class MaxMin {
    /**
     * @param value List.
     * @param comparator Comparator.
     * @param <T>.
     * @return maximum value.
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }

    /**
     * @param value List.
     * @param comparator Comparator.
     * @param <T>.
     * @return minimum value.
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator.reversed());
    }

    private <T> T compare(List<T> value, Comparator<T> comparator) {
        T element = value.get(0);
        for (var el: value) {
            if (comparator.compare(el, element) > 0) {
                element = el;
            }
        }
        return element;
    }
}