package cn.tangshijie.practise;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : tangshijie
 * @since : 2021-10-31 13:11
 */
public class Practise01 {

    public static void main(String[] args) {

        /*
            1.在main方法中启动两个线程
            2.第一个线程循环随机打印100以内的整数
            3.直到第2个线程从键盘读取了"Q"命令
         */
        Thread01 thread01 = new Thread01();
        Runnable thread02 = new Thread02(thread01);
        Thread proxy = new Thread(thread02);
        thread01.start();
        proxy.start();
    }

    static class Thread01 extends Thread {

        private boolean loop = true;

        @Override
        public void run() {
            while (loop) {
                System.out.println(Thread.currentThread().getName() + " " + (int) (101 * Math.random()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        public void setLoop(Boolean loop) {
            this.loop = loop;
        }

    }

    static class Thread02 implements Runnable {

        private final Thread01 thread01;

        Thread02(Thread01 thread01) {
            this.thread01 = thread01;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " " + "输入Q结束线程1");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            if ("Q".equals(next)) {
                thread01.setLoop(false);
            }
        }
    }

}
