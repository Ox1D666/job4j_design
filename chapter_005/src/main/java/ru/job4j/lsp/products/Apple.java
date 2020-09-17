package ru.job4j.lsp.products;

import java.time.Instant;

public class Apple extends Food {
    public Apple(String name, int price, Instant createDate, Instant expireDate, int discount) {
        super(name, price, createDate, expireDate, discount);
    }
}
