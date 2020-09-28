package ru.job4j.isp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleMenuTest {
    @Test
    public void whenAddThreeRoots() {
        Item root = new Item("root", new ArrayList<>());
        SimpleMenu<Item> menu = new SimpleMenu<>(root);
        Item one = new Item("one", new ArrayList<>());
        Item two = new Item("two", new ArrayList<>());
        Item three = new Item("three", new ArrayList<>());
        Item oneOne = new Item("-one.one", new ArrayList<>());
        Item oneTwo = new Item("-one.two", new ArrayList<>());
        Item oneThree = new Item("-one.three", new ArrayList<>());
        Item oneOneOne = new Item("--one.one.one", new ArrayList<>());
        Item oneOneTwo = new Item("--one.one.two", new ArrayList<>());
        menu.add(root, one);
        menu.add(root, two);
        menu.add(root, three);
        menu.add(one, oneOne);
        menu.add(one, oneTwo);
        menu.add(one, oneThree);
        menu.add(oneOne, oneOneOne);
        menu.add(oneOne, oneOneTwo);
        System.out.println(menu.print(root));
    }
}