package ru.job4j.lsp.superstore;

import ru.job4j.lsp.superstore.products.Food;
import ru.job4j.lsp.superstore.store.Store;

import java.util.List;

/**
 * Class to control where every product should be.
 */
public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    /**
     * if the expiration date  0 - 25% put in warehouse;
     * if the expiration date  25% - 75% put in shop;
     * if the expiration date  75% - 99% give a discount;
     * if the expiration date  100% put in trash;
     * @param products
     */
    public void distribute(List<Food> products) {
        for (var product : products) {
            for (var store : stores) {
                if (store.accept(product)) {
                    break;
                }
            }
        }
    }
}
