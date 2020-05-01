package ru.job4j.structures.generics;

import java.util.Iterator;
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

    public SimpleLinkedList() {
        this.head = new Node<>(null, null, this.tail);
        this.tail = new Node<>(this.head, null, null);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * @param e the element to add
     */
    public void addLast(E e) {
        Node<E> prev = tail;
        Node<E> newNode = new Node<>(prev, e, null);
        tail = newNode;
        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        Objects.checkIndex(index, size);

        return
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
