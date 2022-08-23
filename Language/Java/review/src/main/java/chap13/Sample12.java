package chap13;

import java.time.LocalDate;

public class Sample12 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

        LocalDate date2 = LocalDate.parse("1945-08-15");
        System.out.println(date2);

        LocalDate date3 = LocalDate.parse("2020-06-03");

        System.out.printf("%s년은 %s입니다.\n", date3.getYear(), (date3.isLeapYear() ? "윤년" : "평년"));
        System.out.printf("오늘은 %s일 입니다.\n", date1.getDayOfMonth());

        System.out.printf("1년 전의 날짜는 %s\n", date1.minusYears(1));
    }
}
