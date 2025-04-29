package Collection;

import java.util.*;

public class list {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,10);
        list.add(1,12);
        list.remove(1);
        list.remove((Integer)10);
        System.out.println(list);

        java.util.List<String> list2 = new ArrayList<>(Arrays.asList("A","B","C"));
        System.out.println(list2);
        for(String s : list2){
            System.out.println(s);
        }
        ListIterator<String> iterator = list2.listIterator();
        iterator.next();
        iterator.set("X");
        System.out.println(list2);
    }


}
