package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/1").get();
        Locale ru = new Locale("ru");
        DateFormatSymbols instance = DateFormatSymbols.getInstance(ru);
        instance.setShortMonths(new String[]{"янв", "февр", "мар", "апр", "мая", "июн", "июл", "авг", "сент", "окт", "нояб", "дек"});
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yy, HH:mm", ru);
        format.setDateFormatSymbols(instance);
        Elements row = doc.selectFirst(".forumTable").select(".postslisttopic");
        for (Element td : row) {
            Element href = td.child(0);
            System.out.println(href.attr("href"));
            System.out.println(href.text());
            System.out.println(format.parse(td.lastElementSibling().text()));
        }
    }
}