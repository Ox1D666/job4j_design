package ru.job4j.kiss;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = null;
        for (var el: value) {
            if (comparator.compare(el, max) > 0) {
                max = el;
            }
        }
        return max;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return null;
    }
}