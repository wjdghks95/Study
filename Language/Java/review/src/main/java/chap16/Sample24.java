package chap16;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Sample24 {
    public static void main(String[] args) {
        String greeting = "Hello";
        Consumer<String> consumer = System.out::println;
        consumer.accept(greeting);

        writeString(greeting::toString);
    }

    public static void writeString(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}
