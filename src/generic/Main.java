package generic;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        Integer i = a.test();

        String[] strings = new String[1];
        Main.add(strings, "Hello");
        System.out.println(Arrays.toString(strings));

        Integer[] arr = {1, 4, 5, 2, 6, 3, 0, 7, 9, 8};
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        /*
        Arrays.sort(arr, new Comparator<Integer>() {  //Integer为泛型的定义
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
                //compare方法要求返回一个int来表示两个数的大小关系，大于0表示大于，小于0表示小于
                //这里直接o2-o1就行，如果o2比o1大，那么肯定应该排在前面，所以说返回正数表示大于
            }
        });
        */
        System.out.println(Arrays.toString(arr));


    }

    static class A implements Study<Integer> { //接口
        @Override
        public Integer test() {
            return null;
        }
    }

    private static <T>void add(T[] arr, T t){ //方法
        arr[0] = t;
    }
}