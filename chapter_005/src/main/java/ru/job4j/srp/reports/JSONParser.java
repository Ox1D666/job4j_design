package ru.job4j.srp.reports;

import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.Store;

import java.util.List;

/**
 * Parse report to JSON.
 */
public class JSONParser {
    /**
     * Store with employee.
     */
    private Store store;

    public JSONParser(Store store) {
        this.store = store;
    }

    /**
     * Generate report.
     * @return
     */
    public String parse(List<Employee> employee) {
        StringBuilder report = new StringBuilder();
        for (var el : employee) {
            report.append(String.format("{%s\"name\": %s,%s\"hired\": %s,%s\"fired\": %s,%s\"salary\": %s%s}",
                    System.lineSeparator(),
                    el.getName(),
                    System.lineSeparator(),
                    el.getHired(),
                    System.lineSeparator(),
                    el.getFired(),
                    System.lineSeparator(),
                    el.getSalary(),
                    System.lineSeparator()));
        }
        return report.toString();
    }
}
