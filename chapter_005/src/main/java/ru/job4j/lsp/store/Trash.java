package ru.job4j.lsp.store;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.ShelfLIfe;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> products = new ArrayList<>();
    private final ShelfLIfe shelfLIfe = new ShelfLIfe();

    @Override
    public void add(Food food) {
        products.add(food);
        System.out.println(products.get(0).getName());
    }

    @Override
    public boolean accept(Food food) {
        if (shelfLIfe.checkDateExpiration(food) == 100) {
            add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> remove() {
        List<Food> result = products;
        products.clear();
        result.get(0).getName();
        return result;
    }
}
