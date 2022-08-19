package chap08.sample10;

interface Bow {
    String sayHello();
    String sayBye();
}
public class Sample14 {
    public static void main(String[] args) {
        String name = "빵형";
        Bow bow = new Bow() {

            @Override
            public String sayHello() {
                return name + " 안녕!";
            }

            @Override
            public String sayBye() {
                return name + " 잘가!";
            }
        };
        System.out.println(bow.sayBye());
    }
}
