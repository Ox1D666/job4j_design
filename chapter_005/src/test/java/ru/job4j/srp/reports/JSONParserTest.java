package ru.job4j.srp.reports;

import org.junit.Test;
import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class JSONParserTest {
    @Test
    public void whenDefaultReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        List<Employee> employees = List.of(new Employee("Ivan", now, now, 110.0));
        employees.forEach(store::add);
        JSONParser result = new JSONParser(store);
        String expect = String.format("{%s\"name\": %s,%s\"hired\": %s,%s\"fired\": %s,%s\"salary\": %s%s}",
                System.lineSeparator(),
                employees.get(0).getName(),
                System.lineSeparator(),
                employees.get(0).getHired(),
                System.lineSeparator(),
                employees.get(0).getFired(),
                System.lineSeparator(),
                employees.get(0).getSalary(),
                System.lineSeparator());
        assertThat(result.parse(store.findBy(em -> true)), is(expect));
    }
}