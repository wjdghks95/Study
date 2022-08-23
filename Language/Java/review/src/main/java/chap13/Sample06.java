package chap13;

import java.text.DecimalFormat;
import java.util.Locale;

public class Sample06 {
    public static void main(String[] args) {
        double myMoney1 = 2000000;
        double myMoney3 = 1000000;
        double myMoney2 = -2000000;
        double amount = myMoney1 / myMoney3;

        DecimalFormat df = new DecimalFormat("(수익)#,##0;(손실)#,##0");
        System.out.println(df.format(myMoney1));
        System.out.println(df.format(myMoney2));
        DecimalFormat df1 = new DecimalFormat("##0%");
        System.out.println(df1.format(amount));
    }
}
