package ru.job4j.lsp.store;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.ShelfLIfe;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private  List<Food> products = new ArrayList<>();
    private final ShelfLIfe shelfLIfe = new ShelfLIfe();

    @Override
    public void add(Food food) {
        products.add(food);
    }

    @Override
    public boolean accept(Food food) {
        if (shelfLIfe.checkDateExpiration(food) > 25 && shelfLIfe.checkDateExpiration(food) != 100) {
            if (shelfLIfe.checkDateExpiration(food) > 75) {
                food.setDiscount(30);
            }
            add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> remove() {
        List<Food> result = new ArrayList<>(products);
        products.clear();
        return result;
    }
}
