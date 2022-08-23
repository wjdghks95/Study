package chap13;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Sample15 {
    public static void main(String[] args) {
        Date date1 = new Date();
        LocalDateTime date2 = LocalDateTime.now();
        System.out.println("date : " + date1);
        System.out.println("local : " + date2);

        date1.setMonth(date1.getMonth() + 3);
        date2.plusMonths(3);

        System.out.println("date : " + date1);
        System.out.println("local : " +  date2.plusMonths(3));

        LocalDateTime date3 = LocalDateTime.now(ZoneId.of("Asia/Colombo"));
        System.out.println(date3);

        ZoneId.getAvailableZoneIds()
                .stream()
                .forEach(System.out::println);
    }
}
