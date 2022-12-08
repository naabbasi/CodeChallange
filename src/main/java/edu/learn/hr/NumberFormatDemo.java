package edu.learn.hr;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 8, 5);
        System.out.println(dayFormat.format(calendar.getTime()));

        //https://www.oracle.com/java/technologies/javase/jdk8-jre8-suported-locales.html
        Double payment = 12324.134;
        NumberFormat us = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(new Locale("zh", "CN"));
        NumberFormat france = NumberFormat.getCurrencyInstance(new Locale("fr", "FR"));

        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}
