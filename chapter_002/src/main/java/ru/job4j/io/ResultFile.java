package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        SimpleCalc simpleCalc = new SimpleCalc();
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(simpleCalc.sum(2, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
