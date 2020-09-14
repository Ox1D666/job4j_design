package ru.job4j.srp.reports;

import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.Store;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

/**
 * Report for Developers dep.
 */
public class ProgrammerReport implements Report {
    /**
     * Store with employee.
     */
    private Store store;

    public ProgrammerReport(Store store) {
        this.store = store;
    }

    /**
     * Generate report, with all employee, in HTML.
     * @param filter
     * @return
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        StringBuilder report = new StringBuilder(System.lineSeparator());
        report.append("<!DOCTYPE html>");
        report.append("<html>");
        report.append("<head>");
        report.append("<title>Report</title>");
        report.append("<meta charset=\"utf-8\">");
        report.append("</head>");
        report.append("<body>");
        report.append("<table>");
        report.append("<thead>");
        report.append("<tr>");
        report.append("<th>Name</th>");
        report.append("<th>Hired</th>");
        report.append("<th>Fired</th>");
        report.append("<th>Salary</th>");
        report.append("</tr>");
        report.append("</thead>");
        report.append("<tbody>");
        for (Employee el : employees) {
            report.append("<tr>");
            report.append(String.format("<td>%s</td>", el.getName()));
            report.append(String.format("<td>%s</td>", el.getHired()));
            report.append(String.format("<td>%s</td>", el.getFired()));
            report.append(String.format("<td>%s</td>", el.getSalary()));
            report.append("</tr>");
        }
        report.append("</table>");
        report.append("</tbody>");
        report.append("</html>");
        return report.toString();
    }
}
