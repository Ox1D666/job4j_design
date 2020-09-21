package ru.job4j.lsp;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.store.Shop;
import ru.job4j.lsp.store.Store;
import ru.job4j.lsp.store.Trash;
import ru.job4j.lsp.store.Warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
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
