package ru.job4j.srp.reports;

import org.junit.Test;
import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ProgrammerReportTest {
    @Test
    public void whenReportInHTML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        List<Employee> employees = List.of(new Employee("Ivan", now, now, 110.0));
        employees.forEach(store::add);
        Report result = new ProgrammerReport(store);
        StringBuilder expect = new StringBuilder(System.lineSeparator());
        expect.append("<!DOCTYPE html>");
        expect.append("<html>");
        expect.append("<head>");
        expect.append("<title>Report</title>");
        expect.append("<meta charset=\"utf-8\">");
        expect.append("</head>");
        expect.append("<body>");
        expect.append("<table>");
        expect.append("<thead>");
        expect.append("<tr>");
        expect.append("<th>Name</th>");
        expect.append("<th>Hired</th>");
        expect.append("<th>Fired</th>");
        expect.append("<th>Salary</th>");
        expect.append("</tr>");
        expect.append("</thead>");
        expect.append("<tbody>");
        expect.append("<tr>");
        expect.append(String.format("<td>%s</td>", employees.get(0).getName()));
        expect.append(String.format("<td>%s</td>", employees.get(0).getHired()));
        expect.append(String.format("<td>%s</td>", employees.get(0).getFired()));
        expect.append(String.format("<td>%s</td>", employees.get(0).getSalary()));
        expect.append("</tr>");
        expect.append("</table>");
        expect.append("</tbody>");
        expect.append("</html>");
        assertThat(result.generate(em -> true), is(expect.toString()));
    }
}