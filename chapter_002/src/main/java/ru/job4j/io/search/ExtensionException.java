package ru.job4j.io.search;

import java.nio.file.Path;

public class ExtensionException implements SearchCondition {
    private String ext;

    public ExtensionException(String ext) {
        this.ext = ext;
    }

    @Override
    public boolean check(Path path) {
        if (!path.getFileName().endsWith(ext)) {
            return true;
        }
        return false;
    }
}
