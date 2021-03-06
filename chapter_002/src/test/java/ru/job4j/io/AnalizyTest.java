package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("server.log");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(source)))) {
            String lineSep = System.lineSeparator();
            writer.write("200 10:56:01" + lineSep
                    + "200 10:57:01" + lineSep
                    + "400 10:58:01" + lineSep
                    + "200 10:59:01" + lineSep
                    + "500 11:01:02" + lineSep
                    + "200 11:02:02");
        } catch (IOException e) {
            e.printStackTrace();
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            while (reader.ready()) {
                assertThat(reader.readLine(), is("10:58:01;10:59:01"));
                assertThat(reader.readLine(), is("11:01:02;11:02:02"));
            }
        }
    }

}