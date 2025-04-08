package process;

public class Fibonacci {
    public static int Calculate(int target){
        if(target == 1 || target == 2){
            return 1;
        }
        else{
            return Calculate(target-1) + Calculate(target-2);
        }
    }
    public static void solve(){
        int target = 7;
        System.out.println(Calculate(target));
    }
}
