package ru.job4j.design.srp.reports;

import ru.job4j.design.srp.store.Employer;

import java.util.List;

public interface Report {

    String generateReport(List<Employer> makeReport);
}
