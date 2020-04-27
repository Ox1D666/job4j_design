package ru.job4j.structures.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(4);
    }

    @Test
    public void whenAddSetRemoveAndGetElement() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.set(1, 99);
        assertThat(simpleArray.get(1), is(99));
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(3));
    }
    @Test
    public void whenUseBuiltInIterator() {

    }
}

