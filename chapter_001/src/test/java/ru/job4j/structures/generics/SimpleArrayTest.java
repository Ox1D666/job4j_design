package ru.job4j.structures.generics;

import org.junit.Test;
import ru.job4j.structures.generics.SimpleArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void whenAddSetRemoveAndGetElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[] {1, 2, 3, 4});
        simpleArray.set(1, 99);
        assertThat(simpleArray.get(1), is(99));
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(3));
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[] {1, 2, 3});
        assertThat(simpleArray.iterator().hasNext(), is(true));
        assertThat(simpleArray.iterator().hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[] {1, 2, 3});
        assertThat(simpleArray.iterator().next(), is(1));
        assertThat(simpleArray.iterator().next(), is(2));
        assertThat(simpleArray.iterator().next(), is(3));
    }
}

