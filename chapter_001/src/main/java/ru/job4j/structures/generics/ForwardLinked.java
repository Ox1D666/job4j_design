package ru.job4j.structures.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    private Node<T> tail;

    private int size;

    public int getSize() {
        return size;
    }

    public void add(T value) {
        var newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else if (tail == null) {
            tail = newNode;
            head.next = tail;
            tail.prev = head;
        } else {
            tail.next = newNode;
            var old = tail;
            tail = newNode;
            newNode.prev = old;
        }
    }

    public T get(int index) {
        Node<T> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    public void deleteFirst() {
        if (iterator().hasNext()) {
            head = head.next;
        } else {
            throw new NoSuchElementException();
        }
    }

    public T deleteLast() {
        T result = null;
        if (iterator().hasNext()) {
            result = tail.value;
            tail = tail.prev;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }
}
