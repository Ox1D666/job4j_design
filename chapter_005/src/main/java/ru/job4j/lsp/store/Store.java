package ru.job4j.lsp.store;

import ru.job4j.lsp.products.Food;

import java.util.List;

public interface Store {
    void add(Food food);
    boolean accept(Food food);
    List<Food> remove();
}
