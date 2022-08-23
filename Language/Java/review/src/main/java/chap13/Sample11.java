package chap13;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Sample11 {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today);

        SimpleDateFormat format1 = new SimpleDateFormat("YYYY년 MM월 dd일 E HH시 mm분 ss초");
        System.out.println(format1.format(today));

        SimpleDateFormat format2 = new SimpleDateFormat("YYYY년 MM월 dd일 EEEE a HH시 mm분 ss초");
        System.out.println(format2.format(today));

        SimpleDateFormat format3 = new SimpleDateFormat("YYYY MM dd EEEE a HH:mm:ss", new Locale("en", "US"));
        System.out.println(format3.format(today));

        SimpleDateFormat format4 = new SimpleDateFormat("YYYY MM dd EEEE a HH:mm:ss", Locale.ENGLISH);
        System.out.println(format4.format(today));
    }
}
