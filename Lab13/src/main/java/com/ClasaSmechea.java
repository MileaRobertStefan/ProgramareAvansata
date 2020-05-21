package com;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ClasaSmechea {
    private Locale locale;
    private DateFormatSymbols dateFormatSymbols;
    private Currency currency;
    private ResourceBundle resources;

    private String promt;
    private String info;
    private String invalid;
    private String locales;

    public ClasaSmechea() throws IOException {
        this.dateFormatSymbols = DateFormatSymbols.getInstance();
        locale = new Locale("ro", "RO");
        resources = ResourceBundle.getBundle("res.Messages", locale);
        setLocale("ro","RO");

    }

    public void displayLocales() {
        System.out.println(locales);
        Locale[] available = Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + "\t" +
                    locale.getDisplayLanguage(locale));
        }
    }

    public void setLocale(String languege,String country) {
        locale = new Locale(languege,country);
        resources = ResourceBundle.getBundle("res.Messages", locale);
        promt = resources.getString("prompt");
        info = resources.getString("info");
        invalid = resources.getString("invalid");
        locales = resources.getString("locales");
    }

    public void info() {
        Object[] arguments = {locale.getDisplayLanguage()};
        String msg = new MessageFormat(resources.getString("info")).format(arguments);
        System.out.println(msg);
        currency = Currency.getInstance(locale);
        DateFormatSymbols symbols = new DateFormatSymbols(locale);

        System.out.println("Country: " + locale.getDisplayCountry() + " ( " + locale.getDisplayCountry(locale) + "  )");
        System.out.println("Language: " + locale.getDisplayLanguage() + " ( " + locale.getDisplayLanguage(locale) + " ) ");

        String number = NumberFormat.getCurrencyInstance(locale).format(1);
        System.out.println("Currency: " + number + " ( " + currency.getDisplayName(locale) + " )");

        System.out.println("Week Days: " + Arrays.toString(symbols.getWeekdays()));
        System.out.println("Months: " + Arrays.toString(symbols.getMonths()));

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        System.out.println("Today: " + today.format(formatter));


    }

    public String getPromt() {
        return promt;
    }

    public String getInfo() {
        return info;
    }

    public String getInvalid() {
        return invalid;
    }

    public String getLocales() {
        return locales;
    }
}
