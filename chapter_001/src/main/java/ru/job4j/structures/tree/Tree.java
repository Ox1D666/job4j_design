package ru.job4j.structures.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent() && findBy(child).isEmpty()) {
            root.children.add(new Node<>(child));
            return true;
        }
        return false;
    }

    public boolean isBinary() {
        return isBinary(root);
    }

    private boolean isBinary(Node<E> node) {
        boolean result = false;
        if (node.children.size() <= 2) {
            result = true;
            for (Node<E> child : node.children) {
                if (!isBinary(child)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
