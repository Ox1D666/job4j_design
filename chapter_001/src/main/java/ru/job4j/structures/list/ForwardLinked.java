package ru.job4j.structures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        size++;
    }

    public T get(int index) {
        Node<T> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    public T deleteFirst() {
        T result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    public T deleteLast() {
        T result = tail.value;
        if (head == null) {
            throw new NoSuchElementException();
        }
        size--;
        if (head.next == null) {
            result = head.value;
            head = null;
            return result;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return result;
    }

    public void revert() {
        Node<T> node = head; // поместили 1 в node
        while (node != null) {
            Node<T> tmp = node.next; // поместили 2 в tmp
            node.next = node.prev; // в следующий после 1 поместили null
            node.prev = tmp; // в предыдущий поместили 2
            node = tmp; // взяли следующий элемент
        }
        node = tail; // сохраняем хвост
        tail = head; // ссылаем голову на хвост
        head = node; // ссылаем хвост на голову
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
