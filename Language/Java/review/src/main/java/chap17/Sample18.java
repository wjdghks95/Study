package chap17;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sample18 {
    public static void main(String[] args) {
        String[][] level = {
                {"빵형", "초급"}, {"타노스", "중급"}, {"상도", "고급"}, {"상도", "특급"}
        };

        Map<String, String> map = Arrays.stream(level)
                .collect(Collectors.toMap(x -> x[0], x -> x[1], (x1, x2) -> x1 + ", " + x2));
        System.out.println(map);
    }
}
