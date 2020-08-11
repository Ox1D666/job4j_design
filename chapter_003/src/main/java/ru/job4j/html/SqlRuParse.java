package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SqlRuParse {
    private Locale language = new Locale("ru");
    private SimpleDateFormat dateFormatAll = new SimpleDateFormat("dd MMM yy, HH:mm", language);
    private SimpleDateFormat todayAndYesterday = new SimpleDateFormat("dd MMM yy", language);

    public static void main(String[] args) throws Exception {
        SqlRuParse sqlRuParse = new SqlRuParse();
        sqlRuParse.parse();
    }

    public SqlRuParse() {
        DateFormatSymbols instance = DateFormatSymbols.getInstance(language);
        instance.setShortMonths(new String[]{"янв", "февр", "мар", "апр", "май", "июн", "июл",
                "авг", "сент", "окт", "нояб", "дек"});
        dateFormatAll.setDateFormatSymbols(instance);
        todayAndYesterday.setDateFormatSymbols(instance);
    }

    private void parse() throws Exception {
        Calendar date = Calendar.getInstance();
        for (int page = 1; page <= 5; page++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + page).get();
            Elements row = doc.selectFirst(".forumTable").select(".postslisttopic");
            printPage(date, row, dateFormatAll, todayAndYesterday);
        }
    }

    private void printPage(Calendar date, Elements row, SimpleDateFormat dateFormatAll,
                           SimpleDateFormat todayAndYesterday)
            throws Exception {
        for (Element td : row) {
            Element href = td.child(0);
            System.out.println(href.attr("href"));
            System.out.println(href.text());
            String dateText = td.lastElementSibling().text();
            if (dateText.contains("сегодня")) {
                String time = dateText.split(" ")[1];
                System.out.println(todayAndYesterday.format(date.getTime()) + ", " + time);
            } else if (dateText.contains("вчера")) {
                String time = dateText.split(" ")[1];
                date.add(Calendar.DATE, -1);
                System.out.println(todayAndYesterday.format(date.getTime()) + ", " + time);
            } else {
                System.out.println(dateFormatAll.format(dateFormatAll.parse(dateText)));
            }
        }
    }
}