package ru.job4j.lsp.store;

import ru.job4j.lsp.products.Food;

import java.util.List;

public class Trash implements Store {
    private final List<Food> products;

    public Trash(List<Food> products) {
        this.products = products;
    }

    @Override
    public void add(Food food) {

    }

    @Override
    public void remove(Food food) {

    }
}
