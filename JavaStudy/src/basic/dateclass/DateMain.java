package basic.dateclass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateMain {
    public static void main(String[] args) {
        Date nowDate = new Date();
        System.out.println(nowDate);    //Thu Dec 22 20:36:09 KST 2022
        Date tomorrowDate = new Date(2022, 12,23);
        System.out.println(nowDate.before(tomorrowDate));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss zzz");
        System.out.println(dateFormat.format(nowDate)); //2022-12-22 08:36:09 KST

        Calendar calendar = Calendar.getInstance();     //return GregorianCalendar
        System.out.println(calendar.getTime());     //Thu Dec 22 20:37:18 KST 2022, return Date Object
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);   //January is 0
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));

        LocalDate curDate = LocalDate.now();
        System.out.println(curDate);    //2022-12-22
        LocalDate targetDate = LocalDate.of(2022, 12, 22);
        System.out.println(targetDate); //2022-12-22

        LocalTime curTime = LocalTime.now();
        System.out.println(curTime);    //20:43:51.588505400
        LocalTime targetTime = LocalTime.of(20, 44, 20);
        System.out.println(targetTime); //20:44:20

        LocalDateTime curDateTime = LocalDateTime.now();
        System.out.println(curDateTime);    //2022-12-22T20:45:07.795500500
        LocalDateTime targetDateTime = LocalDateTime.of(targetDate, targetTime);
        System.out.println(targetDateTime); //2022-12-22T20:44:20
        System.out.println(curDateTime.getYear());
        System.out.println(curDateTime.getMonth());     //DECEMBER
        System.out.println(curDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); //2022-12-22 20:49:17

        //Date -> LocalDateTime
        LocalDateTime convertedLocalDateTime = nowDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        System.out.println(convertedLocalDateTime);      //2022-12-22T20:52:39.662

        convertedLocalDateTime = new java.sql.Timestamp(nowDate.getTime()).toLocalDateTime();
        System.out.println(convertedLocalDateTime);      //2022-12-22T20:52:39.662

        convertedLocalDateTime = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());  //over Java 9
        System.out.println(convertedLocalDateTime);      //2022-12-22T20:52:39.662

        //LocalDateTime -> Date
        Date convertedDate = java.sql.Timestamp.valueOf(curDateTime);
        System.out.println(convertedDate);      //2022-12-22 22:58:09.3429324

        convertedDate = Date.from(curDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(convertedDate);      //Thu Dec 22 22:59:58 KST 2022

        //LocalDate -> Date
        convertedDate = java.sql.Date.valueOf(curDate);
        System.out.println(convertedDate);      //2022-12-22

        LocalDate localDate = LocalDate.now();
        convertedDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(convertedDate);      //Thu Dec 22 00:00:00 KST 2022
    }
}
