package ru.job4j.isp;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class SimpleMenu<E> implements Menu<E> {
    private StringBuilder report = new StringBuilder();
    private final Node<E> root;

    public SimpleMenu(E root) {
        this.root = new Node<>(root);
        this.report.append(String.format("%s%s", root.toString(), System.lineSeparator()));
    }

    @Override
    public void add(E parent, E child) {
        if (get(parent).isPresent()) {
            get(parent).get().children.add(new Node<>(child));
        }
    }

    @Override
    public Optional<Node<E>> get(E item) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(item)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public String print(E item) {
        for (var el : get(item).get().children) {
            report.append(String.format("%s%s", el.value, System.lineSeparator()));
            if (!el.children.isEmpty()) {
                print(el.value);
            }
        }
        return report.toString();
    }
}