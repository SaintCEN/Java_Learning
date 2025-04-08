package object_senior.practice;

public class back_string {
    public static void main(String[] args){
        String str = "ababa";
        String str2 = new StringBuilder(str).reverse().toString();
        System.out.println(str.equals(str2));
    }
}
