package ru.job4j.structures.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    @Test
    public void whenAddOriginalNumber() {
        SimpleSet<Integer> set = new SimpleSet<>();
        List<Integer> list = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

    }

}