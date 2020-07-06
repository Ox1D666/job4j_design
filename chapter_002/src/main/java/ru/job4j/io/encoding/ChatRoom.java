package ru.job4j.io.encoding;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ChatRoom {
    private Input input;
    private final String path;
    private static int work = 0;
    private final static String EXIT = "exit";
    private final static String GO = "go";
    private final static String STOP = "stop";
    private List<String> words;

    public ChatRoom(Input input, String path) {
        this.input = input;
        this.path = path;
    }

    public void init(File path) throws IOException {
        getWords();
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                        new FileOutputStream(path)))) {
            while (work != -1) {
                String str = input.ask();
                out.write(str);
                out.println();
                if (str.equals(EXIT)) {
                    out.close();
                    work = -1;
                } else if (!str.equals(STOP)) {
                    System.out.println(writeSomeWord());
                } else {
                    while (!str.equals(GO)) {
                        str = input.ask();
                        out.write(str);
                        out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getWords() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            this.words = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String writeSomeWord() {
        return this.words.get(new Random().nextInt(words.size()));
    }
}
