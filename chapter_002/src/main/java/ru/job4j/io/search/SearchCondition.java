package ru.job4j.io.search;

import java.nio.file.Path;

public interface SearchCondition {
    boolean check(Path path);
}
