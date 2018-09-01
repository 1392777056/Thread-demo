package com.demo;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/24 15:59
 */

/**
 * 买火车票的案例  -----  线程安全问题
 */
public class MyTest {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(ticket,"AAA").start();
        new Thread(ticket,"BBB").start();
        new Thread(ticket,"CCC").start();
    }

}
