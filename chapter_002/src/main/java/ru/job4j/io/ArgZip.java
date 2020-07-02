package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return false;
    }

    public String directory() {
        return args[4];
    }

    public String exclude() {
        return args[6];
    }

    public String output() {
        return args[8];
    }
}
