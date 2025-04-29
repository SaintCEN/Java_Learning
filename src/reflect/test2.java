package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test2 {
    static class student {
        public int score = 100;
        public void test() {
            System.out.println("AAA");
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
            Class<student> clazz = student.class;
            student student1 = clazz.newInstance();
            student1.test();
            Method method = clazz.getMethod("test");
            method.invoke(student1);

            Field field = clazz.getField("score");
            System.out.println(field);
    }
}
