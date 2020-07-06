package ru.job4j.io;

import ru.job4j.io.search.ExtensionException;
import ru.job4j.io.search.PrintFiles;
import ru.job4j.io.search.Search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (var file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public List<File> search(File root, ArgZip argZip) throws IOException {
        PrintFiles printFiles = new PrintFiles(new ExtensionException(argZip.exclude()));
        Files.walkFileTree(root.toPath(), printFiles);
        return printFiles.getPaths().stream().map(Path::toFile).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip();
        zip.packFiles(zip.search(new File(argZip.directory()), argZip), new File(argZip.output()));
    }
}
