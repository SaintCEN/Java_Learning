package reflect;

public class test1 {
    public static void main(String[] args){
        Integer i = 10;
        System.out.println(i.getClass().asSubclass(Number.class));
        System.out.println(i.getClass().getSuperclass());
    }
}
