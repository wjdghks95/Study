package chap13;

import java.util.Calendar;
import java.util.Date;

public class Sample02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date);

        System.out.println("== Date ==");
        System.out.printf("%s %02d %02d:%02d:%02d, KST %d\n",
                getWeekName(date.getDay() + 1)
                , date.getDate()
                , date.getHours()
                , date.getMinutes()
                , date.getSeconds()
                , date.getYear() + 1900);

        System.out.println("== Calendar ==");
        System.out.printf("%s %02d %02d:%02d:%02d, KST %d\n",
                getWeekName(cal.get(Calendar.DAY_OF_WEEK))
                , cal.get(Calendar.DAY_OF_MONTH)
                , cal.get(Calendar.HOUR_OF_DAY)
                , cal.get(Calendar.MINUTE)
                , cal.get(Calendar.SECOND)
                , cal.get(Calendar.YEAR));
    }

    public static String getWeekName(int WeekNumber) {
        String day = "";
        switch (WeekNumber) {
            case Calendar.SUNDAY :
                    day = "Sun";
            break;
            case Calendar.MONDAY :
                day = "Mon";
                break;
            case Calendar.TUESDAY :
                day = "Tue";
                break;
            case Calendar.WEDNESDAY :
                day = "Wed";
                break;
            case Calendar.THURSDAY :
                day = "Thu";
                break;
            case Calendar.FRIDAY :
                day = "Fri";
                break;
            case Calendar.SATURDAY :
                day = "Sat";
                break;
            default: throw new IllegalArgumentException("Unexpected value: " + WeekNumber);
        }
        return day;
    }
}
