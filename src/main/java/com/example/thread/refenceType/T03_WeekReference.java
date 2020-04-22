package com.example.thread.refenceType;

import java.lang.ref.WeakReference;

/***
 * 弱引用遭遇到gc就会被回收
 * 解决某些地方内存泄露的问题
 */
public class T03_WeekReference {
    static ThreadLocal<M> t = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        WeakReference w = new WeakReference<>(new M());
        System.out.println(w.get());
        test();
        Thread.sleep(2000);
        System.out.println(w.get());

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
