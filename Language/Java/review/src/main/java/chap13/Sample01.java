package chap13;

import java.util.Calendar;
import java.util.Date;

public class Sample01 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        Date date = cal.getTime();
        System.out.println(date);
        System.out.println(date.getDate());
        System.out.println(Calendar.FRIDAY);
    }
}
