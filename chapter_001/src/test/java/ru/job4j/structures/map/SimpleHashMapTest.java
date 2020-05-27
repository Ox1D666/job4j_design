package ru.job4j.structures.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleHashMapTest {
    @Test
    public void whenInsertAnsGetItem() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "Alex");
        map.insert(2, "Ann");
        map.insert(3, "Bob");
        assertThat(map.get(1), is("Alex"));
    }

    @Test
    public void delete() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "Alex");
        map.insert(2, "Ann");
        map.insert(3, "Bob");
        map.delete(3);
        assertThat(map.get(3), is(nullValue()));
    }

    @Test
    public void whenReadSequence() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "Alex");
        map.insert(2, "Ann");
        SimpleHashMap.Node<Integer, String> node = map.iterator().next();
        Iterator<SimpleHashMap.Node<Integer, String>> iter = map.iterator();
        assertThat(iter.next().getKey(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next().getKey(), is(2));
        assertThat(iter.hasNext(), is(false));
    }
}