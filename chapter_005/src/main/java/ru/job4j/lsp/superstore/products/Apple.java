package ru.job4j.lsp.superstore.products;

import java.time.LocalDate;

public class Apple extends Food {
    public Apple(String name, int price, LocalDate createDate, LocalDate expireDate) {
        super(name, price, createDate, expireDate);
    }
}
