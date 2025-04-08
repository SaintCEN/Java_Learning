package object_senior.practice;

public class hanoi {
    public static void solve(int n) {
        move(n, 'A', 'C', 'B');
    }
    /*
    当n等于 1 时，直接把圆盘从起始柱移动到目标柱，并输出移动信息。
    当n大于 1 时，先把n - 1个圆盘从起始柱借助目标柱移动到辅助柱。
    接着把第n个圆盘从起始柱移动到目标柱，并输出移动信息。
    最后把n - 1个圆盘从辅助柱借助起始柱移动到目标柱。
    */
    public static void move(int n, char from, char to, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        move(n - 1, from, auxiliary, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        move(n - 1, auxiliary, to, from);
    }

    public static void main(String[] args) {
        int n = 4;
        solve(n);
    }
}