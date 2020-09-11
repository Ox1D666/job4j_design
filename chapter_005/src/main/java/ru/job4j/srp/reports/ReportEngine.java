package ru.job4j.srp.reports;

import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.Store;
import java.util.function.Predicate;

/**
 * Creating reports.
 */
public class ReportEngine implements Report {
    /**
     * Store with employee.
     */
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    /**
     * Generate report, with all employee.
     * @param filter
     * @return
     */
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
}