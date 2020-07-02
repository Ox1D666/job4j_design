package ru.job4j.io.encoding;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ChatRoom {
    private Input input;
    private final String path;
    private static int work = 0;

    public ChatRoom(Input input, String path) {
        this.input = input;
        this.path = path;
    }

    public void init() throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                        new FileOutputStream("./chapter_002/data/chatLog.txt")))) {
            while (work != -1) {
                String str = input.ask();
                out.write(str);
                out.println();
                if (str.equals("exit")) {
                    out.close();
                    work = -1;
                } else if (!str.equals("stop")) {
                    System.out.println(writeSomeWord());
                } else {
                    while (!str.equals("go")) {
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

    public String writeSomeWord() throws IOException {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            List<String> words = reader.lines().collect(Collectors.toList());
            Random rand = new Random();
            result = words.get(rand.nextInt(words.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
