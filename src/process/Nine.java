package process;

public class Nine {
    public static void solve() {
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println("\n");
        }
    }
}
