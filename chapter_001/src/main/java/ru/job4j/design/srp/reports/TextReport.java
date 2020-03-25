package ru.job4j.design.srp.reports;

import ru.job4j.design.srp.store.Employer;
import ru.job4j.design.srp.store.Store;

import java.util.List;

public class TextReport implements Report {

    @Override
    public String generateReport(List<String> makeReport) {
        StringBuilder sb = new StringBuilder();
        makeReport.forEach(sb::append);
        return sb.toString();
    }
}


//.append(System.lineSeparator())
//        .append("</head>")
//        .append(System.lineSeparator())
//        .append("<body>")
//        .append(System.lineSeparator());
//        for (Map.Entry<String, String> item : map.entrySet()) {
//        String key = item.getKey().substring(3);
//        String value = item.getValue();
//        html.append("<p>").append(key).append(value).append("</p>")
//        .append(System.lineSeparator());
//        }
//        html.append(System.lineSeparator())
//        .append("</body>")
