package Collection;

import java.util.*;

public class set {
    public static void main(String[] args){
        Set<String> set1 = new HashSet<>();
        System.out.println(set1.add("AAA"));
        System.out.println(set1.remove("AAA"));
        System.out.println(set1);

        Set<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set);

        TreeSet<Integer> set3 = new TreeSet<>((a, b) -> b - a);  //同样是一个Comparator
        set3.add(1);
        set3.add(3);
        set3.add(2);
        System.out.println(set3);
    }
}
