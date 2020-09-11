package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.srp.deps.Department;
import ru.job4j.srp.deps.HRDepartment;
import ru.job4j.srp.deps.ITDepartment;
import ru.job4j.srp.reports.Report;
import ru.job4j.srp.reports.ReportEngine;
import ru.job4j.srp.reports.TextReport;
import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.MemStore;

import java.util.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Report text = new TextReport();
        Department it = new ITDepartment();
        Employee worker = new Employee("Ivan", now, now, 100);
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
        List<Employee> employees = List.of(new Employee("Ivan", now, now, 110.0),
                new Employee("Alex", now, now, 120.0),
                new Employee("Tom", now, now, 130.0));
        employees.forEach(store::add);
        ReportEngine report = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Tom;130.0").append(";")
                .append("Alex;120.0").append(";")
                .append("Ivan;110.0").append(";");
        assertThat(report.generate(em -> true, text, it), is(expect.toString()));
    }
}