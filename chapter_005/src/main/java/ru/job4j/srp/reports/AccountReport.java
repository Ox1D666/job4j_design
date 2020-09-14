package ru.job4j.srp.reports;

import ru.job4j.srp.store.Employee;

import java.util.function.Predicate;

public class AccountReport implements Report {
    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
