package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Menu<E> {
    void add(E parent, E child);
    Optional<Node<E>> get(E item);
    String print(E item);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
