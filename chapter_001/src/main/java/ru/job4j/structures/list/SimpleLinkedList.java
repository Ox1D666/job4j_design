package ru.job4j.structures.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int size = 0;

    /**
     * Pointer to first node.
     */
    private Node<E> head;

    /**
     * Pointer to last node.
     */
    private Node<E> tail;

    private int modCount = 0;

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.value = element;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * @param value the element to add
     */
    public void add(E value) {
        var newNode = new Node<E>(value);
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
        modCount++;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private Node<E> current = head;
            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.value;
                current = current.next;
                iterIndex++;
                return element;
            }
        };
    }
}
