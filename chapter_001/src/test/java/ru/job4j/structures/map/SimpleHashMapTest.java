package ru.job4j.structures.map;

import org.junit.Test;

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
        SimpleHashMap.Node<Integer, String> nodeOne = map.iterator().next();
        assertThat(nodeOne.getKey(), is(1));
        assertThat(map.iterator().hasNext(), is(true));
        SimpleHashMap.Node<Integer, String> nodeTwo = map.iterator().next();
        assertThat(nodeTwo.getKey(), is(2));
        assertThat(map.iterator().hasNext(), is(false));
    }
}