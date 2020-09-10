package ru.job4j.srp.deps;

import ru.job4j.srp.store.Employer;
import ru.job4j.srp.store.Store;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ITDepartment implements Department {
    @Override
    public List<String> makeReport(Predicate<Employer> filter, Store store) {
        return store.findBy(filter).stream().map(Object::toString).collect(Collectors.toList());
    }
}
