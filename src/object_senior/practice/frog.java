package object_senior.practice;

public class frog {
    public static int Calculate(int n){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else{
            return Calculate(n-1)+Calculate(n-2);
        }
    }

    public static void main(String[] args){
        int n = 10;
        System.out.println(Calculate(n));
    }
}
