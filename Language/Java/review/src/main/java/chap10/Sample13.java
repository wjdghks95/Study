package chap10;

class NumberBox {
    public <Z extends Number> void setNumber(Z z) {
        System.out.printf("입력된 값은 [%s] 입니다.\n", z.toString());
    }
}

public class Sample13 {
    public static void main(String[] args) {
        NumberBox bn = new NumberBox();
        bn.setNumber(20002);
        bn.setNumber(123.45678);
//        bn.setNumber("asds");
    }
}
