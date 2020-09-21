package ru.job4j.lsp.products;

import java.time.Instant;
import java.time.LocalDate;

/**
 * Abstract model of product which we want to sell.
 */
public abstract class Food {
    private String name;
    private int price;
    private LocalDate createDate;
    private LocalDate expireDate;
    private int discount;

    public Food(String name, int price, LocalDate createDate, LocalDate expireDate) {
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + ", discount=" + discount + '}';
    }
}
