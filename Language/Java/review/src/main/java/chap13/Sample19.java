package chap13;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Sample19 {
    public static void main(String[] args) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss - vvvv");
        System.out.println(format1.format(ZonedDateTime.now()));
    }
}
