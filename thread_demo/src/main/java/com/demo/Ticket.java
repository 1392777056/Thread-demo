package com.demo;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/24 16:01
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 注意事项：
 * 1.小括号之内的锁对象必须是引用类型，不能是基本类型（和JVM底层结构有关系）。
 * 2.必须是多线程之间的同一把锁。
 *
 * 同步方法：
 * 对于普通的成员方法来说，synchronized关键字的锁的对象是this，synchronized(this) {...}
 * 对于静态方法来说，synchronized关键字对象的是当前类的反射对象，synchronized(当前类.class){...}
 */
public class Ticket implements Runnable {

    // 设置买 100 张票。
    private int tickets = 100;

    // 这个锁的对象是全局唯一的。
    private final Object lock = new Object();

    // 定义一个全局的Look接口
    private final Lock locks = new ReentrantLock();

    public void run() {

        while (true) {

            // 同步代码块
            //synchronized(lock) {
                sell();
            //}

        }

    }
    // 同步方法   在调用方法期间，其他的线程不能被插足。
    private /*synchronized*/ void sell() {

        locks.lock();
        // 有没有票
        if (tickets > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            System.out.println("窗口"+ name +"正在买票：" + tickets--);   // 有的话，减去1张
        }
        locks.unlock();  // 必须释放锁，否则会一致霸占这把锁，会有重入的现象，就是这个实现ReentrantLock类的效果。
    }
}
