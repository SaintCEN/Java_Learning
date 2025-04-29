package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class tools {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,0);
        list.add(1,1);
        Integer a = Collections.max(list);
        Integer b = Collections.min(list);
        System.out.println(a+" "+b);

        List<Integer> list2 = Arrays.asList(2, 3, 8, 9, 10, 13);
        System.out.println(Collections.binarySearch(list2, 8));
        Collections.fill(list2,1);
        System.out.println(list2);

        List<Integer> newList = Collections.unmodifiableList(list);

        List list3 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list3 = Collections.checkedList(list3, Integer.class);   //这里的.class关键字我们会在后面反射中介绍，表示Integer这个类型
        list3.add("aaa");
        System.out.println(list);
    }
}
