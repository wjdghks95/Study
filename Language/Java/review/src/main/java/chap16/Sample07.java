package chap16;

import java.util.function.Supplier;

public class Sample07 {
    public static void main(String[] args) {
        MessageCenter mc = new MessageCenter("Hello~ Lambda!");
        Supplier<MessageCenter> param = () -> mc;
        MessageCenter main = getMsg(() -> mc);
        System.out.println(main);
    }

    public static MessageCenter getMsg(Supplier<MessageCenter> m) {
        return m.get();
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
