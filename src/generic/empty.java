package generic;

import java.util.Optional;

public class empty {
    private static void test(String str){
        Integer i = Optional
                .ofNullable(str)
                .map(String::length)   //使用map来进行映射，将当前类型转换为其他类型，或者是进行处理
                .orElse(-1);
        System.out.println(i);
    }
    public static void main(String[] args){
        test(null);
    }
}
