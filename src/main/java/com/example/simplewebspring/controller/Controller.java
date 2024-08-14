package com.example.simplewebspring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Controller {

    public LocalDate normalizeDate(String dateString) {
        dateString = dateString.replaceAll("\\s", "");

        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = originalFormat.parse(dateString);
            String formattedDateString = targetFormat.format(date);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate formattedDate = LocalDate.parse(formattedDateString, formatter);

            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
