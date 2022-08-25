package chap16;

public class Sample01 {
    public static void main(String[] args) {
        Sample01Function f = () -> System.out.println("샘플01테스트 출력");

        f.test();

        Sample01Function f1 = new Sample01Function() {
            @Override
            public void test() {
                System.out.println("샘플01테스트 출력");
            }
        };

        f1.test();

        Sample02Function f2 = (a) -> a;
        System.out.println(f2.test("샘플02테스트 출력"));

        Sample02Function f3 = a -> {
            return a;
        };


    }
}

@FunctionalInterface
interface Sample01Function {
    public void test();
}

@FunctionalInterface
interface Sample02Function {
    public String test(String a);
}
