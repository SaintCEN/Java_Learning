package object_senior;

import java.util.Random;

public class math {
    public static void main(String[] args) {
        System.out.println(Math.pow(5, 3));
        int a = Math.abs(-1);
        int b = Math.max(19, 20);
        int c = Math.min(2, 4);
        double d  = Math.sqrt(9);
        double e = Math.sin(Math.PI / 2);
        double f = Math.cos(Math.PI);
        double g = Math.tan(Math.PI / 4);
        double h = Math.asin(1);
        double i = Math.acos(1);
        double j = Math.atan(0);
        double k = Math.log(Math.E);
        double l = Math.log10(100);
        double m = Math.log(4) / Math.log(2);//换底公式
        double n = Math.ceil(4.5);
        double o = Math.floor(5.6);

        Random random = new Random();
        System.out.println(random.nextInt(0,100));
    }
}
