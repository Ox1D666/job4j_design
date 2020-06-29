package ru.job4j.io.search;

import ru.job4j.io.search.ExtensionCondition;
import ru.job4j.io.search.PrintFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        PrintFiles printFiles = new PrintFiles(new ExtensionCondition(ext));
        Files.walkFileTree(root, printFiles);
        return printFiles.getPaths();
    }
}
