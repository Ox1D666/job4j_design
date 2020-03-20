package ru.job4j.design.srp.reports;

import ru.job4j.design.srp.store.Employer;
import ru.job4j.design.srp.store.Store;
import ru.job4j.design.srp.deps.Department;

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
    public String generate(Predicate<Employer> filter, Report report, Department department) {
        return report.generateReport(department.makeReport(filter, store));
    }
}