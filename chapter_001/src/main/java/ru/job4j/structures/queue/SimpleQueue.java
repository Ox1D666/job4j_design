package ru.job4j.structures.queue;

import ru.job4j.structures.list.SimpleStack;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        return null;
    }

    public void push(T value) {
    }
}
