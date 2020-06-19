package ru.job4j.io;

import java.io.*;

/**
 * Check when server was down.
 */
public class Analizy {
    /**
     * Record the time when status is 400 or 500.
     * @param source all time when server work.
     * @param target record time in this file when server is down.
     */
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String serverDown = null;
            while (reader.ready()) {
                String status = reader.readLine();
                if (serverDown == null && (status.startsWith("400") || status.startsWith("500"))) {
                    writer.write(status.split(" ")[1] + ";");
                    serverDown = status;
                } else if (serverDown != null && (!status.startsWith("400") && !status.startsWith("500"))) {
                    writer.write(status.split(" ")[1]);
                    serverDown = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.log", "./data/unavailable.csv");
    }
}