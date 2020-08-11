package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/1").get();
        Locale ru = new Locale("ru");
        DateFormatSymbols instance = DateFormatSymbols.getInstance(ru);
        instance.setShortMonths(new String[]{"янв", "февр", "мар", "апр", "мая", "июн", "июл", "авг", "сент", "окт", "нояб", "дек"});
        SimpleDateFormat dateFormatALL = new SimpleDateFormat("dd MMM yy, HH:mm", ru);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy", ru);
        dateFormatALL.setDateFormatSymbols(instance);
        dateFormat.setDateFormatSymbols(instance);
        Calendar cal = Calendar.getInstance();
        Elements row = doc.selectFirst(".forumTable").select(".postslisttopic");
        for (Element td : row) {
            Element href = td.child(0);
            System.out.println(href.attr("href"));
            System.out.println(href.text());
            String date = td.lastElementSibling().text();
            if (date.contains("сегодня")) {
                String time = date.split(" ")[1];
                System.out.println(dateFormat.format(cal.getTime()) + ", " + time);
            } else if (date.contains("вчера")) {
                String time = date.split(" ")[1];
                cal.add(Calendar.DATE, -1);
                System.out.println(dateFormat.format(cal.getTime()) + ", " + time);
            } else {
                System.out.println(dateFormatALL.format(dateFormatALL.parse(td.lastElementSibling().text())));
            }
        }
    }
}