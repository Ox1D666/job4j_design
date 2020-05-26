package ru.job4j.structures.queue;

import ru.job4j.structures.list.SimpleStack;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while (in.size() > 0) {
            out.push(in.pop());
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
