package ru.job4j.structures.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    @Test
    public void whenAddNotOriginalElements() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(1);
        Iterator<Integer> iter = set.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(false));
    }
}