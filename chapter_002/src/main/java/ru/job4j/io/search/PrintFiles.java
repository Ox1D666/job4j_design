package ru.job4j.io.search;

import ru.job4j.io.search.ExtensionCondition;
import ru.job4j.io.search.SearchCondition;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class PrintFiles implements FileVisitor<Path> {
    private SearchCondition sc;
    private List<Path> paths = new ArrayList<>();

    public List<Path> getPaths() {
        return paths;
    }

    public PrintFiles(SearchCondition sc) {
        this.sc = sc;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (sc.check(file)) {
            paths.add(file.getFileName());
        }
        System.out.println(file.toAbsolutePath());
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}
