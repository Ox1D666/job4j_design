package ru.job4j.lsp.superstore.products;

import java.time.LocalDate;

public class ShelfLIfe {
    /**
     * Check expiration date percentage.
     * @param food
     * @return percentage representation.
     */
    public int checkDateExpiration(Food food) {
        int create = food.getCreateDate().getDayOfYear();
        int expiration = food.getExpireDate().getDayOfYear();
        int now = LocalDate.now().getDayOfYear();
        return (now - create) * 100 / (expiration - create);
    }
}
