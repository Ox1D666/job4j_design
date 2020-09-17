package ru.job4j.lsp;

import ru.job4j.lsp.products.Food;

/**
 * Class to control where every product should be.
 */
public class ControlQuality {
    /**
     * if the expiration date  0 - 25% put in warehouse;
     * if the expiration date  25% - 75% put in shop;
     * if the expiration date  75% - 99% give a discount;
     * if the expiration date  100% put in trash;
     * @param food
     */
    public void distribute(Food food) {

    }
}
