package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.design.srp.deps.Department;
import ru.job4j.design.srp.deps.HRDepartment;
import ru.job4j.design.srp.deps.ITDepartment;
import ru.job4j.design.srp.reports.Report;
import ru.job4j.design.srp.reports.ReportEngine;
import ru.job4j.design.srp.reports.TextReport;
import ru.job4j.design.srp.store.Employer;
import ru.job4j.design.srp.store.MemStore;

import java.util.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Report text = new TextReport();
        Department it = new ITDepartment();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true, text, it), is(expect.toString()));
    }

    @Test
    public void reportWithoutHiredFiredAndReversSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Report text = new TextReport();
        Department it = new HRDepartment();
        List<Employer> employers = List.of(new Employer("Ivan", now, now, 110.0),
                new Employer("Alex", now, now, 120.0),
                new Employer("Tom", now, now, 130.0));
        employers.forEach(store::add);
        ReportEngine report = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Tom;130.0").append(";")
                .append("Alex;120.0").append(";")
                .append("Ivan;110.0").append(";");
        assertThat(report.generate(em -> true, text, it), is(expect.toString()));
    }
}