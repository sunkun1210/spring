package com.example.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static CountDownLatch countDownLatch =new CountDownLatch(100);
    public static void main(String[] args) {

        for(int i=0;i<100;i++){
            new Thread(()->{
                test();
            }).start();
            countDownLatch.countDown();
        }

    }
    static   void test(){
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hah"+Thread.currentThread().getName());
    }
}

