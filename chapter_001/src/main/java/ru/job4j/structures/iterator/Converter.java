package ru.job4j.structures.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator = it.next();
            @Override
            public boolean hasNext() {
                if (!iterator.hasNext()) {
                    if (it.hasNext()) {
                        iterator = it.next();
                    } else {
                        return false;
                    }
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}
