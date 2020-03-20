package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.design.srp.reports.ReportEngine;
import ru.job4j.design.srp.store.Employer;
import ru.job4j.design.srp.store.MemStore;

import java.util.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void reportWithoutHiredFiredAndReversSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        List<Employer> employers = List.of(new Employer("Ivan", now, now, 110),
                new Employer("Alex", now, now, 120),
                new Employer("Tom", now, now, 130));
        employers.forEach(store::add);
        ReportEngine report = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append("Tom;130").append(";")
                .append("Alex;120").append(";")
                .append("Ivan;110").append(";");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}