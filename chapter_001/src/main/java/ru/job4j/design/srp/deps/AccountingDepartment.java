package ru.job4j.design.srp.deps;

import ru.job4j.design.srp.store.Employer;
import ru.job4j.design.srp.store.Store;

import java.util.List;
import java.util.function.Predicate;

public class AccountingDepartment implements Department {
    @Override
    public List<Employer> makeReport(Predicate<Employer> filter, Store store) {
        return null;
    }
}
