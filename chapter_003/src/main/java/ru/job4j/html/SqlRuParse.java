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
    public static void main(String[] args) throws Exception {
        SqlRuParse sqlRuParse = new SqlRuParse();
        Locale language = new Locale("ru");
        DateFormatSymbols instance = sqlRuParse.setNewNameForRuMonth(language);
        sqlRuParse.init(language, instance);
    }

    private void init(Locale language, DateFormatSymbols instance) throws Exception {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateFormatAll = new SimpleDateFormat("dd MMM yy, HH:mm", language);
        SimpleDateFormat todayAndYesterday = new SimpleDateFormat("dd MMM yy", language);
        dateFormatAll.setDateFormatSymbols(instance);
        todayAndYesterday.setDateFormatSymbols(instance);
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

    private DateFormatSymbols setNewNameForRuMonth(Locale language) {
        DateFormatSymbols instance = DateFormatSymbols.getInstance(language);
        instance.setShortMonths(new String[]{"янв", "февр", "мар", "апр", "май", "июн", "июл",
                "авг", "сент", "окт", "нояб", "дек"});
        return instance;
    }
}