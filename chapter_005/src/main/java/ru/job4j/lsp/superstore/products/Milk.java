package ru.job4j.lsp.superstore.products;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, int price, LocalDate createDate, LocalDate expireDate) {
        super(name, price, createDate, expireDate);
    }
}
