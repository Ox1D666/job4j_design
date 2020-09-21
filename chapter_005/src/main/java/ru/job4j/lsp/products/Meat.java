package ru.job4j.lsp.products;

import java.time.Instant;
import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, int price, LocalDate createDate, LocalDate expireDate) {
        super(name, price, createDate, expireDate);
    }
}
