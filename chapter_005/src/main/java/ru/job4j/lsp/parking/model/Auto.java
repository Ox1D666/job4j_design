package ru.job4j.lsp.parking.model;

public abstract class Auto {
    private String name;
    private int size;

    public Auto(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Auto{"
                + "name='" + name + '\''
                + ", size=" + size + '}';
    }
}
