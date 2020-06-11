package ru.job4j.structures.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    @Test
    public void whenDelete() {
        Analize analize = new Analize();
        List<Analize.User> prev = new LinkedList<>();
        List<Analize.User> cur = new LinkedList<>();
        prev.add(new Analize.User(1, "first"));
        prev.add(new Analize.User(2, "second"));
        prev.add(new Analize.User(3, "third"));
        cur.add(new Analize.User(2, "second"));
        int deleted = analize.diff(prev, cur).deleted;
        assertThat(deleted, is(2));
    }

    @Test
    public void whenAdd() {
        Analize analize = new Analize();
        List<Analize.User> prev = new LinkedList<>();
        prev.add(new Analize.User(1, "first"));
        prev.add(new Analize.User(2, "second"));
        prev.add(new Analize.User(3, "third"));
        List<Analize.User> cur = new LinkedList<>(prev);
        cur.add(new Analize.User(4, "fourth"));
        int added = analize.diff(prev, cur).added;
        assertThat(added, is(1));
    }

    @Test
    public void whenAddThenChange() {
        Analize analize = new Analize();
        List<Analize.User> prev = new LinkedList<>();
        List<Analize.User> cur = new LinkedList<>();
        prev.add(new Analize.User(1, "first"));
        prev.add(new Analize.User(2, "second"));
        cur.add(new Analize.User(1, "first"));
        cur.add(new Analize.User(2, "second"));
        cur.get(0).name = "firstNew";
        int changed = analize.diff(prev, cur).changed;
        assertThat(changed, is(1));
    }
}