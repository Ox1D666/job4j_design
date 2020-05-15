package ru.job4j.structures.map;

import java.util.Arrays;
import java.util.Iterator;

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
        if (size >= table.length) {
            table = Arrays.copyOf(table, table.length * 2);
        }
        boolean result = false;
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new Node<>(key, value);
            result = true;
            size++;
        } else {
            table[index].value = value;
        }
        return result;
    }

    private V get(K key) {
        return table[getIndex(key)].value;
    }

    private boolean delete(K key) {
        boolean result = false;
        if (getIndex(key) >= 0) {
            table[getIndex(key)] = null;
            result = true;
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

    @Override
    public Iterator<SimpleHashMap.Node<K, V>> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public SimpleHashMap.Node<K, V> next() {
                return null;
            }
        };
    }
}
