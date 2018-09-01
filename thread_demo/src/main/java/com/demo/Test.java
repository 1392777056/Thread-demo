package com.demo;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/25 22:08
 */
public class Test {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("后输出");
            }
        }).start();

        System.out.println("我先输出");

    }

}
