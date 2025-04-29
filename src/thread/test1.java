package thread;

import com.sun.tools.javac.Main;

public class test1 {
    private static int value = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("我是一号线程：" + i);
                if(i==20) Thread.yield();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("我是二号线程：" + i);
                if(i==30) {
                    try {
                        System.out.println("线程1加入到此线程！");
                        t1.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        t2.start();

        System.out.println("l");
        Thread.sleep(1000);
        System.out.println("b");
        Thread.sleep(1000);
        System.out.println("w");
        Thread.sleep(1000);
        System.out.println("nb!");

        Thread t3 = new Thread(() -> {
            System.out.println("线程开始运行！");
            while (true){   //无限循环
                if(Thread.currentThread().isInterrupted()){   //判断是否存在中断标志
                    break;   //响应中断
                }
            }
            System.out.println("线程被中断了！");
        });
        t3.start();
        try {
            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
            t3.interrupt();   //调用t的interrupt方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t4 = new Thread(() -> {
            System.out.println("线程开始运行！");
        });
        t4.start();
        t4.setPriority(Thread.MIN_PRIORITY);  //通过使用setPriority方法来设定优先级

        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Main.class){  //使用synchronized关键字创建同步代码块
                    value++;
                }
            }
            System.out.println("线程5完成");
        });
        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Main.class){
                    value++;
                }
            }
            System.out.println("线程6完成");
        });
        t5.start();
        t6.start();
        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
        System.out.println(value);
    }
}
