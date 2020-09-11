package ru.job4j.srp.reports;

import org.junit.Test;
import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class HRReportTest {
    @Test
    public void reportWithoutHiredFiredAndReversSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        List<Employee> employees = List.of(new Employee("Ivan", now, now, 110.0),
                new Employee("Alex", now, now, 120.0),
                new Employee("Tom", now, now, 130.0));
        employees.forEach(store::add);
        Report report = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append("Tom;130.0").append(";")
                .append("Alex;120.0").append(";")
                .append("Ivan;110.0").append(";");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}