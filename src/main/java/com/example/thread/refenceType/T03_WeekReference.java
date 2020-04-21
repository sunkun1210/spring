package com.example.thread.refenceType;

import java.lang.ref.WeakReference;

/***
 * 弱引用遭遇到gc就会被回收
 * 解决某些地方内存泄露的问题
 */
public class T03_WeekReference {

    public static void main(String[] args) throws InterruptedException {
        WeakReference w = new WeakReference<>(new M());
        System.out.println(w.get());
        test();
        Thread.sleep(2000);
        System.out.println(w.get());
        ThreadLocal<M> t = new ThreadLocal<>();
        t.set(new M());
        System.gc();
        Thread.sleep(2000);
        System.out.println("=="+t.get());
    }
        static void test(){
            new Thread(() -> {
                System.gc();
            });
        }
}
