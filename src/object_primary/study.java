package object_primary;

public interface study extends A{
    void hard();

    default void test(){
        System.out.println("Default.");
    }

    static void angry(){
        System.out.println("Woo.");
    }
}
