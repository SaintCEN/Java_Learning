package Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class map {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "小明");
        map.put(2, "小红");
        map.compute(2,(k,v)-> v+"A");
        map.replace(1,"CC");
        System.out.println(map.get(2));
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.remove(1,"CC");

        Map<String , String> map2 = new LinkedHashMap<>();
        map2.put("0", "十七张");
        map2.put("+", "牌");
        map2.put("P", "你能秒我");
        System.out.println(map2);
        System.out.println(map2.keySet());
        System.out.println(map2.values());

        Map<Integer , String> map3 = new TreeMap<>((a, b) -> b - a);
        map3.put(0, "单走");
        map3.put(1, "一个六");
        map3.put(3, "**");
        System.out.println(map3);

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("a", 1);
        map4.put("b", 2);
        map4.merge("a", 10, Integer::sum);
        map4.merge("c", 3, Integer::sum);
        System.out.println(map4);
    }
}
