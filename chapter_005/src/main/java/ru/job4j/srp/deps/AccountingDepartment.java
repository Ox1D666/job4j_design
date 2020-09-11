package ru.job4j.srp.deps;

import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.Store;

import java.util.List;
import java.util.function.Predicate;

public class AccountingDepartment implements Department {
    @Override
    public List<String> makeReport(Predicate<Employee> filter, Store store) {
        return null;
    }
}
