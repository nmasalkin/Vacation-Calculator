package ru.vsu.cs.masalkin.vacationcalculator.data;

import java.util.List;

public class CalendarData {
    public int year;
    public List<MonthData> months;

    public static class MonthData {
        public int month;
        public String days;

        public int getMonth() {
            return month;
        }

        public String getDays() {
            return days;
        }
    }
}