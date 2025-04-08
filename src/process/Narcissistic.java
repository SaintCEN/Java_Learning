package process;

public class Narcissistic {
    public static void solve() {
        for (int i = 100; i < 1000; i++) {
            int total = 0;
            int current = i;
            while (current > 0){
                int digit = current % 10;
                total += digit*digit*digit;
                current /= 10;
            }
            if (i == total){
                System.out.println(i);
            }
        }
    }
}
