package ru.job4j.tdd.kiss;

import org.junit.Test;
import static org.hamcrest.Matchers.is;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void whenElementLarger() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        MaxMin maxMin = new MaxMin();
        Integer res = maxMin.max(list, Integer::compareTo);
        assertThat(res, is(5));
    }
    @Test
    public void whenElementSmaller() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        MaxMin maxMin = new MaxMin();
        Integer res = maxMin.min(list, Integer::compareTo);
        assertThat(res, is(1));
    }
}