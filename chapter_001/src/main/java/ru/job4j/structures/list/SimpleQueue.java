package ru.job4j.structures.list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while (in.size() != 0) {
            in.push(out.pop());
        }
        return null;
    }

    public void push(T value) {
        in.push(value);
    }
}
