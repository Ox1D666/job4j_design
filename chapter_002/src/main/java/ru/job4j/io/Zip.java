package ru.job4j.io;

import ru.job4j.io.search.ExtensionCondition;
import ru.job4j.io.search.Search;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) throws IOException {
            sources.forEach(file -> {
                try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                    zip.putNextEntry(new ZipEntry(file.getPath()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                        zip.write(out.readAllBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("./chapter_002/pom.xml"),
                new File("./chapter_002/pom.zip")
        );
        ArgZip argZip = new ArgZip(args);
        List<Path> paths;
        Search search = new Search();
        paths = search.search(new File(argZip.directory()).toPath(), argZip.exclude());
        List<File> files = new ArrayList<>();
        ExtensionCondition ec = new ExtensionCondition(argZip.exclude());
        for (var file : paths) {
            if (!ec.check(file)) {
                files.add(file.toFile());
            }
        }
        Zip zip = new Zip();
        zip.packFiles(files, new File(argZip.output()));
    }
}
