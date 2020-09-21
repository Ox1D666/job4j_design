package ru.job4j.lsp.products;

import org.junit.Test;
import ru.job4j.lsp.ControlQuality;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShelfLIfeTest {
    @Test
    public void whenTenPercentLeft() {
        ShelfLIfe sl = new ShelfLIfe();
        Food apple = new Apple("GrannySmith", 100, LocalDate.of(2020, Month.SEPTEMBER, 20),
                LocalDate.of(2020, Month.SEPTEMBER, 30));
        assertThat(sl.checkDateExpiration(apple), is(10));
    }
}