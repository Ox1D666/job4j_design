package ru.job4j.structures.generics.store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class UserStoreTest {
    UserStore store;
    @Before
    public void setUp() {
        store = new UserStore();
    }
    @Test
    public void whenAddAndFindUserById() {
        User first = new User("1");
        User second = new User("2");
        User third = new User("3");
        store.add(first);
        store.add(second);
        store.add(third);
        assertThat(store.findById("2"), is(second));
    }

    @Test
    public void whenDeleteUser() {
        User first = new User("1");
        store.delete("1");
        User expect = store.findById(first.getId());
        assertNull(expect);
    }

    @Test
    public void whenReplaceUser() {
        User first = new User("1");
        User second = new User("2");
        store.add(first);
        Assert.assertThat(store.replace(first.getId(), second), is(true));
    }
}