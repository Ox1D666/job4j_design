package ru.job4j.srp.reports;

import ru.job4j.srp.store.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
