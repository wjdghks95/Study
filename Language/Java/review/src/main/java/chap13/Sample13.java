package chap13;

import java.time.LocalTime;

public class Sample13 {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.now();
        System.out.println(time1);
        System.out.printf("%2s:%2s:%2s\n", time1.getHour(), time1.getMinute(), time1.getSecond());
        LocalTime time2 = LocalTime.parse("08:10:10");
        System.out.println(time2);
        LocalTime time3 = LocalTime.of(19, 20, 2);
        System.out.println(time3);
        System.out.println("10초 뒤: " + time3.plusSeconds(10));
        System.out.println("10분 전: " + time3.minusMinutes(10));
    }
}
