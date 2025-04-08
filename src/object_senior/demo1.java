package object_senior;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.regex.*;

public class demo1 {
    public static class Person{
        String name;
        int age;
        String sex;
        Person(String name){
            this.name = name;
        }
        public void test(String...strings){
            for(String string:strings){
                System.out.println(string);
            }
            System.out.println(name);//可以访问外部变量
        }
    }

    public boolean isValidEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return Pattern.matches(regex, email);
    }

    public static int test1(int a,int b){
        if(b==0){
            throw new RuntimeException("被除数不能为0！");//throw关键字抛出异常
        }
        return a/b;
    }

    public static int test2(int a) throws FileNotFoundException,ClassNotFoundException{
        if(a==1){
            throw new FileNotFoundException();
        }
        else{
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) {
        BigInteger i = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(i);
        int[] array = new int[10];
        for(int j = 0;j < array.length;j++){
            array[j] = j;
        }
        for(int m : array){
            System.out.println(m);
        }
        array[0] = 114514;
        System.out.println(array.equals(array));
        int[][] array_2 = new int[2][10];

        Person person = new Person("SaintCHEN");
        person.test("111","222","333");

        String str = "Hello World";
        String sub = str.substring(0,3);
        String[] strings = str.split(" ");
        System.out.println(sub);
        StringBuilder builder = new StringBuilder();
        builder.append(str).append(sub);
        builder.delete(2,4);
        System.out.println(builder);
    }
}
