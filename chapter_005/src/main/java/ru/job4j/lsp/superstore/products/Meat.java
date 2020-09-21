package ru.job4j.lsp.superstore.products;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, int price, LocalDate createDate, LocalDate expireDate) {
        super(name, price, createDate, expireDate);
    }
}
