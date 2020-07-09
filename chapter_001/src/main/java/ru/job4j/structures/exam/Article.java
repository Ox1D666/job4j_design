package ru.job4j.structures.exam;

import java.util.Arrays;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        List<String> first = Arrays.asList(origin.split("[,:.!\\s]+"));
        String[] second = line.split("[,;:.!?\\s]+");
        for (var word : second) {
            if (!first.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
