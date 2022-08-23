package chap13;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Sample16 {
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println("*. 시스템 기본 시간 : " + ldt1);

        ZoneId seoulZone = ZoneId.of("Asia/Seoul");
        ZoneId bangkokZone = ZoneId.of("Asia/Bangkok");
        ZoneId sydneyZone = ZoneId.of("Australia/Sydney");

        LocalDateTime ldt2 = LocalDateTime.now(seoulZone);
        System.out.println("\n1. LocalDateTime 서울 : " + ldt2);

        LocalDateTime ldt3 = LocalDateTime.now(bangkokZone);
        System.out.println("2. LocalDateTime 방콬 : " + ldt3);

        LocalDateTime ldt4 = LocalDateTime.now(sydneyZone);
        System.out.println("3. LocalDateTime 시드니 : " + ldt4);

        ZonedDateTime zdt1 = ZonedDateTime.now(seoulZone);
        System.out.println("\n1. LocalDateTime 서울 : " + zdt1);

        ZonedDateTime zdt2 = ZonedDateTime.now(bangkokZone);
        System.out.println("2. LocalDateTime 방콕 : " + zdt2);

        ZonedDateTime zdt3 = ZonedDateTime.now(sydneyZone);
        System.out.println("3. LocalDateTime 시드니 : " + zdt3);
        System.out.println("3. LocalDateTime 시드니 : " + zdt1.withZoneSameInstant(sydneyZone));
        System.out.println("3. LocalDateTime 서울 : " + zdt1);

    }
}
