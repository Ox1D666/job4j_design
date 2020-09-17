package ru.job4j.lsp.store;

import ru.job4j.lsp.products.Food;

public interface Store {
    void add(Food food);
    void remove(Food food);
}
