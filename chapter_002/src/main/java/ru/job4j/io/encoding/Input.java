package ru.job4j.io.encoding;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);

    public String ask() {
        return sc.nextLine();
    }
}
