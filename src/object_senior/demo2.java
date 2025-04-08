package object_senior;

import java.io.FileNotFoundException;

public class demo2 {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        demo1.Person teacher = new demo1.Person("11");//静态内部类不依附于对象

        Student student = new Student() {   //在new的时候，后面加上花括号，把未实现的方法实现了
            @Override
            public void test() {
                System.out.println("我是匿名内部类的实现!");
            }
        };
        student.test();

        Worker xm = () -> System.out.println("Work Hard.");//Lambda表达式，只用于有一种方法的接口
        xm.work();

        Study study = Integer::sum;//方法引用
        study.sum(1,2);

        try{
            Object object = null;
            object.toString();
        }catch(NullPointerException e){
            System.out.println("异常错误信息："+e.getMessage());
        }
        finally {
            System.out.println("111");
        }
        System.out.println("Continue");

        int a = 10;
        assert a > 10 : "我是自定义的错误信息";//断言表达式 通常用于测试

        demo1.test1(2,0);
        demo1.test2(1);


    }
}
