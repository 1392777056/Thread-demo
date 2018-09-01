package com.demo1;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/25 15:26
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池的顶级接口：Executor，只管执行任务
 * 常用的线程池子接口：ExecutorService ，还包含线程池的管理的功能
 * 线程池的工具类：Executors，通常通过这个类创建线程池
 *
 * 使用线程池的步骤：
 * 1.通过Executors类来创建线程池
 * 2.通过Runnable接口指定线程任务内容（不推荐用Thread类继承方式）
 * 3.用submit方法把任务提交到线程池当中
 *
 *
 */
public class DemoTheadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 获取最大线程连接数
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runnable task = new Runnable() {
            public void run() {
                System.out.println("线程开始");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束");
            }
        };

        Future<?> future = pool.submit(task);
        System.out.println(future.get());  // null
        /*pool.submit(task);
        pool.submit(task);*/

        // 关闭线程池资源     一般不使用 不关闭
        // pool.shutdown();

    }

}
