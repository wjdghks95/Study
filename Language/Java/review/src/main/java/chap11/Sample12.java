package chap11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sample12 {
    public static void main(String[] args) {
        var map = new HashMap<String, Integer>();
        int idx = 0;
        map.put("java", ++idx);
        map.put("C", ++idx);
        map.put("C++", ++idx);
        map.put("Python", ++idx);
        map.put("JavaScript", ++idx);
        map.put("PHP", ++idx);
        map.put("Visual Basic .NET", ++idx);
        map.put("Delphi", ++idx);

        Map beforeMap = (Map) map.clone();
        Set<String> keys = map.keySet();
        System.out.println("==Enhanced for Loop");
        for (String key : keys) {
            System.out.println("key = " + key);
        }
        System.out.println("==Lambda expression");
        keys.forEach(key -> System.out.println(key));

        System.out.println("==Method references");
        map.keySet().forEach(System.out::println);

        System.out.println("===");
        for (String key : keys) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.printf("총 %d개의 Map entry가 있습니다.\n", keys.size());

        if (map.containsKey("Delphi")) {
            map.remove("Delphi");
        }

        map.put("Ruby", idx);
    }
}
