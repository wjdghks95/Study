package chap13;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Sample18 {
    public static void main(String[] args) {
        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(zdt1));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(zdt1));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(zdt1));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(zdt1));
    }
}
