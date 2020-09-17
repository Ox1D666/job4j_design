package ru.job4j.lsp.products;

import java.time.Instant;

public class Meat extends Food {
    public Meat(String name, int price, Instant createDate, Instant expireDate, int discount) {
        super(name, price, createDate, expireDate, discount);
    }
}
