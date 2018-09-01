package com.demo;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/24 17:44
 */

/**
 * 等待的方法：wait()。一旦调用就会进入Waiting状态，并且释放【锁】
 * 通知的方法：notify()。 一旦调用，那么当前锁上处于waiting状态，将会唤醒。
 *
 * 必须保证两个线程在同一个锁对象上面调用wait 和notify方法。
 */
public class MyWaiting {

    public static void main(String[] args) {

        final Object lock = new Object();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println("进入Waiting状态");
                        try {
                            lock.wait();   //进入Waiting状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("结束等待");
                    }
                }


            }
        },"顾客").start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        System.out.println("老板去唤醒顾客");
                        lock.notify();
                    }
                }


            }
        },"老板").start();

    }

}
