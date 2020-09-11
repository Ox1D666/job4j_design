package ru.job4j.srp.reports;

import ru.job4j.srp.reports.Report;
import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HRReport implements Report {
    /**
     * Store with employee.
     */
    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    /**
     * Generate report, with all employee, without information about hired, fired & with revers salary.
     * @param filter
     * @return
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> revers = reversListOnSalary(filter);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employer : revers) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }

    /**
     * Return list of employee sorted down by salary.
     * @param filter
     * @return
     */
    private List<Employee> reversListOnSalary(Predicate<Employee> filter) {
        return store.findBy(filter).stream().sorted((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()))
                .collect(Collectors.toList());
    }
}
