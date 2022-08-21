package chap10;

// [접근 제어자] static <E> [반환할 자료형] [메서드 명] (E e) { return 반환할 자료형 }

class Data {
    String value;

    public <T> void setValue(T t) {
        this.value = t.toString();
    }

    public String getValue() {
        return value;
    }
}

public class Sample12 {
    public static void main(String[] args) {
        Data data = new Data();
        data.setValue(3);
        data.setValue("3");
        System.out.println(data.getValue());
    }
}
