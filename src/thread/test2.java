package thread;

import java.util.Timer;
import java.util.TimerTask;

public class test2 {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o1){
                try {
                    System.out.println("开始等待");
                    o1.wait();     //进入等待状态并释放锁
                    System.out.println("等待结束！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o1){
                System.out.println("开始唤醒！");
                o1.notify();     //唤醒处于等待状态的线程，但t1还不能立即执行
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                }
                //唤醒后依然需要等待这里的锁释放之前等待的线程才能继续
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();

        ThreadLocal<String> local = new ThreadLocal<>();  //注意这是一个泛型类，存储类型为我们要存放的变量类型
        Thread t3 = new Thread(() -> {
            local.set("lbwnb");   //将变量的值给予ThreadLocal
            System.out.println("变量值已设定！");
            System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量
        });
        Thread t4 = new Thread(() -> {
            System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量
        });
        t3.start();
        Thread.sleep(3000);    //间隔三秒
        t4.start();

        Timer timer = new Timer();    //创建定时器对象
        timer.schedule(new TimerTask() {   //注意这个是一个抽象类，不是接口，无法使用lambda表达式简化，只能使用匿名内部类
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()); //打印当前线程名称
                timer.cancel();
            }
        }, 1000);    //执行一个延时任务

        Thread t = new Thread(()->{
            System.out.println("111");
        });
        t.setDaemon(true);
        t.start();
    }
}
