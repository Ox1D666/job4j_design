package ru.job4j.kiss;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Calculate max and min of two elements by comparator.
 */
public class MaxMin {
    /**
     * Calculate max of two elements.
     * @param value List.
     * @param comparator Comparator.
     * @param <T>.
     * @return maximum value.
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = value.get(0);
        for (var el: value) {
            if (comparator.compare(el, max) > 0) {
                max = el;
            }
        }
        return max;
    }

    /**
     * Calculate min of two elements.
     * @param value List.
     * @param comparator Comparator.
     * @param <T>.
     * @return minimum value.
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        T min = value.get(0);
        for (var el: value) {
            if (comparator.compare(el, min) < 0) {
                min = el;
            }
        }
        return min;
    }
}