package chap16;

import java.util.function.Supplier;

public class Sample07 {
    public static void main(String[] args) {
        MessageCenter mc = new MessageCenter("Hello~ Lambda!");
        MessageCenter main  = getMsg(() -> mc);
        System.out.println(main);
    }

    public static MessageCenter getMsg(Supplier<MessageCenter> mc) {
        return mc.get();
    }

}

class MessageCenter {
    private final String meg;

    MessageCenter(String meg) {
        this.meg = meg;
    }

    @Override
    public String toString() {
        return "MessageCenter{" +
                "meg='" + meg + '\'' +
                '}';
    }
}
