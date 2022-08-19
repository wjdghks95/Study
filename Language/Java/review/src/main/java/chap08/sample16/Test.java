package chap08.sample16;

public class Test {
    public static void main(String[] args) {
        Data data1 = new Data();
        Data data2 = new Data();
        data1.setName("빵형");
        data2.setName("빵형");

        if (data1 == data2) {
            System.out.println("data1과 data2는 주소가 같습니다.");
        } else {
            System.out.println("data1과 data2는 다른 주소입니다.");
        }

        if (data1.equals(data2)) {
            System.out.println("data1과 data2는 같은 값입니다.");
        } else {
            System.out.println("data1과 data2는 다른 값입니다.");
        }
    }
}
