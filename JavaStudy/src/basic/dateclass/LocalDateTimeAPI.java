package basic.dateclass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class LocalDateTimeAPI {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(13,45,20); //13:45:20
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate date2 = LocalDate.parse("2023-10-18");
        LocalTime time2 = LocalTime.parse("13:45:20");

        LocalDateTime dt1 = LocalDateTime.of(2023, Month.OCTOBER, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date3 = dt1.toLocalDate();
        LocalTime time3 = dt1.toLocalTime();


        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);

        Duration d1 = Duration.between(time2, time3);
        Duration d2 = Duration.between(dt1, dt2);
        Duration d3 = Duration.between(instant1, instant2);

        Period p1 = Period.between(date2, date3);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2,6,1);

        LocalDate date4 = date.withYear(2011);
        LocalDate date5 = date.withDayOfMonth(25);
        LocalDate date6 = date.with(ChronoField.MONTH_OF_YEAR, 2);

        LocalDate date7 = date.with(nextOrSame(DayOfWeek.SUNDAY));	//현재 날짜 이후 지정한 요일이 나타나는 날짜
        LocalDate date8 = date2.with(lastDayOfMonth());	//현재 달의 마지막 날짜를 반환

        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); //20230318
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); //2023-03-18

        LocalDate date9 = LocalDate.parse("20230318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date10 = LocalDate.parse("2023-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        LocalDate date11 = LocalDate.parse(formattedDate, formatter);
    }
}
