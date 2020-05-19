package ru.job4j.structures.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    private Node<K, V>[] table;
    private int size;

    public SimpleHashMap() {
        this.table = new Node[16];
    }

    public static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean insert(K key, V value) {
        resize();
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new Node<>(key, value);
            size++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        V result = null;
        if (table[getIndex(key)] != null) {
            result = table[getIndex(key)].value;
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (table[getIndex(key)] != null) {
            table[getIndex(key)] = null;
            result = true;
            size--;
        }
        return result;
    }

    private int getIndex(K key) {
        return (table.length - 1) & hash(key);
    }

    private int hash(K key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private void resize() {
        if (size >= table.length) {
            Node<K, V>[] oldTable = table;
            table = new Node[table.length * 2];
            for (var node : oldTable) {
                if (node != null) {
                    insert(node.key, node.value);
                }
            }
        }
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[counter] == null && counter < size) {
                    counter++;
                }
                return table[counter++];
            }
        };
    }
}
