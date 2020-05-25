package ru.job4j.structures.map;

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

        public K getKey() {
            return key;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean insert(K key, V value) {
        resize();
        if (table[getIndex(key)] == null) {
            table[getIndex(key)] = new Node<>(key, value);
            size++;
            return true;
        } else {
            if (table[getIndex(key)].key.equals(key)) {
                table[getIndex(key)].value = value;
            }
        }
        return false;
    }

    public V get(K key) {
        if (table[getIndex(key)] != null && table[getIndex(key)].key.equals(key)) {
            return table[getIndex(key)].value;
        }
        return null;
    }

    public boolean delete(K key) {
        if (table[getIndex(key)] != null && table[getIndex(key)].key.equals(key)) {
            table[getIndex(key)] = null;
            size--;
            return true;
        }
        return false;
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
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                int count = cursor;
                while (count < size) {
                    if (table[count] != null) {
                        return true;
                    }
                    count++;
                }
                return false;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> result = null;
                if (table[cursor] != null) {
                    result = table[cursor++];
                } else {
                    while (cursor < size) {
                        if (table[cursor] != null) {
                            result = table[cursor++];
                            break;
                        }
                        cursor++;
                    }
                }
                return result;
            }
        };
    }
}
