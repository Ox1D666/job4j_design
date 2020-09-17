package ru.job4j.lsp.store;

import ru.job4j.lsp.products.Food;

import java.util.List;

public class Shop implements Store {
    private final List<Food> products;

    public Shop(List<Food> products) {
        this.products = products;
    }

    @Override
    public void add(Food food) {

    }

    @Override
    public void remove(Food food) {

    }
}
