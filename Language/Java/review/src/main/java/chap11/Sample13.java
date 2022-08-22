package chap11;

import java.util.HashMap;
import java.util.TreeMap;

public class Sample13 {
    public static void main(String[] args) {
        //학번 정보
        System.out.println("HashMap은 정렬되지 않은 Key, Value 형태로 저장");
        var hashmap = new HashMap<String, String>();
        hashmap.put("1902893", "선풍기");
        hashmap.put("1801438", "신문지");
        hashmap.put("1803962", "고무신");
        hashmap.put("1722761", "강속구");
        hashmap.put("1913449", "동백꽃");
        hashmap.put("1804367", "솔까말");
        System.out.println(hashmap);
        System.out.println("\n");
        System.out.println("TreeMap은 정렬하며 Key, Value 형태로 저장");
        var map = new TreeMap<String, String>();
        map.putAll(hashmap);
        System.out.println(map);

        System.out.println("\n");
        System.out.println("학번이 1803959 이거나 더 큰 값을 가진 가장 가까운 학번 정보");
        System.out.println(map.ceilingEntry("1803959"));
        System.out.println(map.ceilingKey("1803959"));
        System.out.println(map.get(map.ceilingKey("1803959")));
    }
}
