package chap13;

import java.text.DecimalFormat;

public class Sample03 {
    public static void main(String[] args) {
        float myMoney = -0.1f;
        System.out.println(myMoney);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println(df.format(myMoney));
    }
}
