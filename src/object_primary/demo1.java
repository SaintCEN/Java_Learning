package object_primary;

public class demo1 {
    final int t = 3;
    String name;
    int age;
    String sex;
    private int m = 3;
    demo1(int age){
        this.age = age;
    }
    public static void Hello(){
        System.out.println("Hello World");
    }
    public static String introduce(String a, String b){
        Hello();
        return a+" "+b;
    }
    void setName(String name){
        this.name = name;
    }
    int get(){
        return m;
    }
    void good(){
        System.out.println("Bravo.");
    }
}
