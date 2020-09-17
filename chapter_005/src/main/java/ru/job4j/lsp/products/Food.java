package ru.job4j.lsp.products;

import java.time.Instant;

/**
 * Abstract model of product which we want to sell.
 */
public abstract class Food {
    private String name;
    private int price;
    private Instant createDate;
    private Instant expireDate;
    private int discount;

    public Food(String name, int price, Instant createDate, Instant expireDate, int discount) {
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.discount = discount;
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

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Instant expireDate) {
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
