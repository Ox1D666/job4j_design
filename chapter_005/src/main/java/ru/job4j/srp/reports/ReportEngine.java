package ru.job4j.srp.reports;

import ru.job4j.srp.store.Employee;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.deps.Department;

import java.util.function.Predicate;

public class ReportEngine {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

//    public String generate(Predicate<Employer> filter) {
//        StringBuilder text = new StringBuilder();
//        text.append("Name; Hired; Fired; Salary");
//        for (Employer employer : store.findBy(filter)) {
//            text.append(employer.getName()).append(";")
//                    .append(employer.getHired()).append(";")
//                    .append(employer.getFired()).append(";")
//                    .append(employer.getSalary()).append(";");
//        }
//        return text.toString();
//    }
    public String generate(Predicate<Employee> filter, Report report, Department department) {
        return report.generateReport(department.makeReport(filter, store));
    }
}