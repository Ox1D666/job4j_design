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
                } else if (serverDown != null && (!status.isEmpty() && !status.startsWith("400") && !status.startsWith("500"))) {
                    writer.write(status.split(" ")[1]);
                    serverDown = null;
                    writer.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        File source = new File("./data/server.log");
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("./data/server.log")))) {
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
        File target = new File("./data/unavailable.csv");
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
    }
}