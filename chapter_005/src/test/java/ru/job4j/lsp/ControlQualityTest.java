package ru.job4j.lsp;

import org.junit.Test;
import ru.job4j.lsp.superstore.products.Apple;
import ru.job4j.lsp.superstore.products.Food;
import ru.job4j.lsp.superstore.store.Shop;
import ru.job4j.lsp.superstore.store.Store;
import ru.job4j.lsp.superstore.store.Trash;
import ru.job4j.lsp.superstore.store.Warehouse;
import ru.job4j.lsp.superstore.ControlQuality;

import java.time.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {
    @Test
    public void whenAddOneProductInWarehouse() {
        List<Food> products = Arrays.asList(new Apple("GrannySmith", 100,
                LocalDate.of(2020, Month.SEPTEMBER, 20),
                LocalDate.of(2020, Month.SEPTEMBER, 30)));
        var warehouse = new Warehouse();
        List<Store> stores = Arrays.asList(warehouse, new Shop(), new Trash());
        ControlQuality cq = new ControlQuality(stores);
        cq.distribute(products);
        assertThat(warehouse.remove(), is(products));
    }

    @Test
    public void whenAddOneProductInShop() {
        List<Food> products = Arrays.asList(new Apple("GrannySmith", 100,
                LocalDate.of(2020, Month.SEPTEMBER, 10),
                LocalDate.of(2020, Month.SEPTEMBER, 30)));
        var shop = new Shop();
        List<Store> stores = Arrays.asList(new Warehouse(), shop, new Trash());
        ControlQuality cq = new ControlQuality(stores);
        cq.distribute(products);
        assertThat(shop.remove(), is(products));
    }

    @Test
    public void whenAddOneProductInShopAndSetDiscount() {
        List<Food> products = Arrays.asList(new Apple("GrannySmith", 100,
                LocalDate.of(2020, Month.SEPTEMBER, 9),
                LocalDate.of(2020, Month.SEPTEMBER, 22)));
        var shop = new Shop();
        List<Store> stores = Arrays.asList(new Warehouse(), shop, new Trash());
        ControlQuality cq = new ControlQuality(stores);
        cq.distribute(products);
        assertThat(shop.remove().get(0).getDiscount() == 30, is(products.get(0).getDiscount() == 30));
    }

    @Test
    public void whenAddOneProductInTrash() {
        List<Food> products = Arrays.asList(new Apple("GrannySmith", 100,
                LocalDate.of(2020, Month.SEPTEMBER, 10),
                LocalDate.of(2020, Month.SEPTEMBER, 30)));
        var shop = new Shop();
        List<Store> stores = Arrays.asList(new Warehouse(), shop, new Trash());
        ControlQuality cq = new ControlQuality(stores);
        cq.distribute(products);
        assertThat(shop.remove(), is(products));
    }
}