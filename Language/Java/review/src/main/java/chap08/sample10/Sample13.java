package chap08.sample10;

interface Greeting {
    public String sayHello(String name);
}

public class Sample13 {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public String sayHello(String name) {
                return name + " 안녕!";
            }
        };
        System.out.println(greeting.sayHello("빵형"));

        Greeting g = (name) -> name + " 안녕!";
        System.out.println(g.sayHello("람다식 빵형"));
    }
}
